package com.nui.controller;

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
import com.nui.service.PetitionService;

@SpringBootApplication(scanBasePackages = {"com.nui.service","com.nui.dao"})
@Controller
@EntityScan("com.nui.entity")
@EnableJpaRepositories("com.nui.dao")
public class PetitionController {
	
	@Autowired
	private PetitionService petitionService;
	
    @GetMapping("/showPetitions.htm")
    public String showPetitions() {
        return "showPetitions";
    }
    
    
    @GetMapping("/createPetition.htm")
    public String showCreatePetitionForm(Model model) {
    	Petition petition = new Petition();
		model.addAttribute("petition", petition);
        return "createPetition";
    }
    
    
    @PostMapping("/createPetition.htm")
    public String createPetition(@ModelAttribute("petition") Petition petition) {
    	System.err.println("petition " + petition);
    	getPetitionService().savePetition(petition);
    	    	
        return "createPetition";
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

	
	
}
