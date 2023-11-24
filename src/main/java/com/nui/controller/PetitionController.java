/**
 * @author Abhilasha Verma
 * Email : A.Verma7@nuigalway.ie 
 * Student Number : 22102028
 */
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.nui.model.Petition;
import com.nui.model.PetitionSignature;
import com.nui.service.PetitionService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
/**
 * Purpose of this PetitionController class is to allow Create Petition,Show all Petitions,Petition details	 and Search Petition
 *  
 */
@SpringBootApplication(scanBasePackages = { "com.nui.service", "com.nui.dao" })
@Controller
@EntityScan("com.nui.entity")
@EnableJpaRepositories("com.nui.dao")
public class PetitionController {

	@Autowired
	private PetitionService petitionService;

	@Autowired
	private ServletContext context;

	/**
	 * Purpose of this method is to fetch all petitions data through PetitionService.getPetitions() and DAO layer PetitionRespository.findAll() then display it through JSP - showPetitions.jsp.
	 * @param model
	 * @return view
	 */
	@GetMapping("/showPetitions.htm")
	public String showPetitions(Model model) {
		model.addAttribute("petitions", getPetitionService().getPetitions());
		return "showPetitions";
	}

	/**
	 * Purpose of this method is to show Petition creation form - createPetition.jsp.
	 * @param model
	 * @return view
	 */
	@GetMapping("/createPetition.htm")
	public String showCreatePetitionForm(Model model) {
		Petition petition = new Petition();
		model.addAttribute("petition", petition);
		return "createPetition";
	}

	/**
	 * Purpose of this  method is to validate and store petition data in database petition table.
	 * It internally calls  PetitionService.savePetition method and DAO layer : PetitionRespository().save method
	 *  It also save uploaded  image on local directory by calling saveImageFile method.
	 *  After successful creation of a petition it uses the showPetitions method to load all petitions from the database and displays them in the showPetitions.jsp file.
	 * @param petition
	 * @param model
	 * @return view
	 * @throws IOException
	 */
	@PostMapping("/createPetition.htm")
	public String createPetition(@ModelAttribute("petition") Petition petition, Model model) throws IOException {
		saveImageFile(petition);
		getPetitionService().savePetition(petition);
		model.addAttribute("petition", petition);
		model.addAttribute("displayMessage", "Petition Created Successfully");
		return showPetitions(model);
	}

	/**
	 * Main method used by spring boot
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PetitionController.class, args);
	}

	/**
	 * Getter method to return petitionService object
	 * @return
	 */
	public PetitionService getPetitionService() {
		return petitionService;
	}

	/**
	 * Setter method to set petitionService object
	 * @param petitionService
	 */
	public void setPetitionService(PetitionService petitionService) {
		this.petitionService = petitionService;
	}

	/**
	 * Purpose of this method is to stores uploaded file in local upload directory
	 * 
	 * @param petition
	 * @throws IOException
	 */
	private void saveImageFile(Petition petition) throws IOException {
		OutputStream outStream = null;
		try {
			UUID uuid = UUID.randomUUID();
			String imageFileName = uuid + petition.getImageFile().getOriginalFilename();
			petition.setImageId(imageFileName);
			// Store file in this directory.
			String uploadPath = context.getRealPath("") + File.separator + "upload";
			Files.createDirectories(Paths.get(uploadPath));
			InputStream filecontent = petition.getImageFile().getInputStream();
			// Store file in this directory.
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

	/**
	 * Purpose of this method is to get details of individual petition by internally calling PetitionService().getPetitionDetails method and getPetitionRespository().findById() method. 
	 * It displays details through viewPetitionDetails.jsp.
	 * @param request
	 * @param model
	 * @return view
	 */
	@GetMapping("/getPetitionDetails.htm")
	public String getPetitionDetails(HttpServletRequest request, Model model) {
		String petitionId = request.getParameter("petitionId");
		Petition petition = getPetitionService().getPetitionDetails(Integer.parseInt(petitionId));
		model.addAttribute("petition", petition);
		PetitionSignature petitionSignature = new PetitionSignature();
		model.addAttribute("petitionSignature", petitionSignature);
		return "viewPetitionDetails";
	}

	/**
	 * Purpose of this method is to return servlet context 
	 * @return context
	 */
	public ServletContext getContext() {
		return context;
	}

	/**
	 * Purpose of this method is to set servlet context
	 * @param context
	 */
	public void setContext(ServletContext context) {
		this.context = context;
	}

	/**
	 * Purpose of this method to sign any petition. It stores signer details into the petition_signature table by internally calling PetitionService().savePetitionSignature method and PetitionSignatureRespository().save method.
	 * @param petitionSignature
	 * @param model
	 * @return view
	 * @throws IOException
	 */
	@PostMapping("/signPetition.htm")
	public String signPetition(@ModelAttribute("petitionSignature") PetitionSignature petitionSignature, Model model)
			throws IOException {
		getPetitionService().savePetitionSignature(petitionSignature);
		model.addAttribute("displayMessage", "Petition Signed Successfully");
		return showPetitions(model);
	}

	/**
	 * Purpose of this method is to display searchPetition.jsp having a search box to search petitions.
	 * @param model
	 * @return view
	 */
	@GetMapping("/showSearchPetition.htm")
	public String showSearchPetition(Model model) {
		return "searchPetition";
	}

	/**
	 * Purpose of this method is to search petitions by title  data.It internally calls PetitionService().searchPetition and PetitionRespository().searchPeitionByTitle method.
	 * @param request
	 * @param model
	 * @return view
	 */
	@PostMapping("/searchPetition.htm")
	public String searchPetition(HttpServletRequest request, Model model) {
		String petitionTitle = request.getParameter("petitionTitle");
		model.addAttribute("petitions", getPetitionService().searchPetition(petitionTitle));
		return "searchPetitionResult";
	}

}
