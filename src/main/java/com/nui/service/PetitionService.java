package com.nui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nui.dao.PetitionRespository;
import com.nui.entity.PetitionEntity;
import com.nui.model.Petition;

@Service
public class PetitionService {

    @Autowired
	private PetitionRespository petitionRespository;

	public PetitionRespository getPetitionRespository() {
		return petitionRespository;
	}

	public void setPetitionRespository(PetitionRespository petitionRespository) {
		this.petitionRespository = petitionRespository;
	}
    
    public void savePetition(Petition petition)
    {
    	PetitionEntity petitionEntity = new PetitionEntity();
    	petitionEntity.setName(petition.getName());
    	petitionEntity.setEmail(petition.getEmail());
    	petitionEntity.setPetitionText(petition.getPetitionText());
    	getPetitionRespository().save(petitionEntity);
    }
    
	
}
