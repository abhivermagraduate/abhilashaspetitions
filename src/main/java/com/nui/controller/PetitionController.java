package com.nui.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nui.model.Petition;
import com.nui.model.PetitionSignature;
import com.nui.service.PetitionService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@SpringBootApplication(scanBasePackages = { "com.nui.service", "com.nui.dao" })
@Controller
@EntityScan("com.nui.entity")
@EnableJpaRepositories("com.nui.dao")
public class PetitionController {

	@Autowired
	private PetitionService petitionService;

	@Autowired
	private ServletContext context;

	@GetMapping("/showPetitions.htm")
	public String showPetitions(Model model) {
		model.addAttribute("petitions", getPetitionService().getPetitions());
		return "showPetitions";
	}

	@GetMapping("/createPetition.htm")
	public String showCreatePetitionForm(Model model) {
		Petition petition = new Petition();
		model.addAttribute("petition", petition);
		return "createPetition";
	}

	@PostMapping("/createPetition.htm")
	public String createPetition(@ModelAttribute("petition") Petition petition, Model model) throws IOException {
		System.err.println("petition " + petition);
		saveImageFile(petition);
		getPetitionService().savePetition(petition);
		model.addAttribute("petition", petition);
		model.addAttribute("displayMessage", "Petition Created Successfully");
		return showPetitions(model);
	}

	public static void main(String[] args) {
		SpringApplication.run(PetitionController.class, args);
	}

	public PetitionService getPetitionService() {
		return petitionService;
	}

	public void setPetitionService(PetitionService petitionService) {
		this.petitionService = petitionService;
	}

	private void saveImageFile(Petition petition) throws IOException {
		OutputStream outStream = null;
		try {
			UUID uuid = UUID.randomUUID();
			String imageFileName = uuid + petition.getImageFile().getOriginalFilename();
			petition.setImageId(imageFileName);
			String uploadPath = context.getRealPath("") + File.separator + "upload";
			Files.createDirectories(Paths.get(uploadPath));
			InputStream filecontent = petition.getImageFile().getInputStream();
			// Store file in this directory.

			System.err.println(uploadPath);
			File targetFile = new File(uploadPath + File.separator + imageFileName);
			outStream = new FileOutputStream(targetFile);
			byte[] buf = new byte[8192];
			int length;
			// Read file content and write it in target file.
			while ((length = filecontent.read(buf)) != -1) {
				outStream.write(buf, 0, length);
			}
		} finally {
			// close output stream.
			if (outStream != null)
				outStream.close();
		}
	}

	@GetMapping("/getPetitionDetails.htm")
	public String getPetitionDetails(HttpServletRequest request, Model model) {
		String petitionId = request.getParameter("petitionId");
		Petition petition = getPetitionService().getPetitionDetails(Integer.parseInt(petitionId));
		model.addAttribute("petition", petition);
		PetitionSignature petitionSignature = new PetitionSignature();
		model.addAttribute("petitionSignature", petitionSignature);
		return "viewPetitionDetails";
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	@PostMapping("/signPetition.htm")
	public String signPetition(@ModelAttribute("petitionSignature") PetitionSignature petitionSignature, Model model)
			throws IOException {
		System.err.println("petition " + petitionSignature);

		getPetitionService().savePetitionSignature(petitionSignature);

		return showPetitions(model);
	}

	@GetMapping("/showSearchPetition.htm")
	public String showSearchPetition(Model model) {
		System.out.println("PetitionController.showSearchPetition()");
		return "searchPetition";
	}

	@GetMapping("/searchPetition.htm")
	public String searchPetition(HttpServletRequest request, Model model) {

		String petitionTitle = request.getParameter("petitionTitle");
		
		model.addAttribute("petitions", getPetitionService().searchPetition(petitionTitle));
		return "searchPetitionResult";
	}

}
