package com.nui.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

	public void savePetition(Petition petition) {
		PetitionEntity petitionEntity = new PetitionEntity();
		petitionEntity.setName(petition.getName());
		petitionEntity.setEmail(petition.getEmail());
		petitionEntity.setPetitionText(petition.getPetitionText());
		java.sql.Timestamp currentDateTime = new java.sql.Timestamp(new java.util.Date().getTime());
		petitionEntity.setCreateDateTime(currentDateTime);
		petitionEntity.setImageId(petition.getImageId());
		petitionEntity.setPetitionTitle(petition.getPetitionTitle());
		petitionEntity.setGeographicArea(petition.getGeographicArea());
		petitionEntity.setPetitionScope(petition.getPetitionScope());
		getPetitionRespository().save(petitionEntity);
	}

	public List<Petition> getPetitions() {
		List<Petition> petitionList = new ArrayList<Petition>();
		List<PetitionEntity> petitionEntities = getPetitionRespository().findAll();
		for (PetitionEntity petitionEntity : petitionEntities) {
			petitionList.add(populatePetition(petitionEntity));
		}
		return petitionList;
	}

	private Petition populatePetition(PetitionEntity petitionEntity) {
		Petition petition = new Petition();
		petition.setEmail(petitionEntity.getEmail());
		petition.setName(petitionEntity.getName());
		petition.setPetitionText(petitionEntity.getPetitionText());
		return petition;
	}

}
