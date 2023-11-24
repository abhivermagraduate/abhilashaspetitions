package com.nui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.nui.dao.PetitionRespository;
import com.nui.dao.PetitionSignatureRespository;
import com.nui.entity.PetitionEntity;
import com.nui.entity.PetitionSignatureEntity;
import com.nui.model.Petition;
import com.nui.model.PetitionSignature;

@Service
public class PetitionService {

	@Autowired
	private PetitionRespository petitionRespository;

	@Autowired
	private PetitionSignatureRespository petitionSignatureRespository;

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
		petitionEntity.setSignatureGoalCount(petition.getSignatureGoalCount());
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
		petition.setPetitionTitle(petitionEntity.getPetitionTitle());
		petition.setImageId(petitionEntity.getImageId());
		petition.setCreateDateTime(petitionEntity.getCreateDateTime());
		petition.setGeographicArea(petitionEntity.getGeographicArea());
		petition.setPetitionScope(petitionEntity.getPetitionScope());
		petition.setId(petitionEntity.getId());
		petition.setSignatureGoalCount(petitionEntity.getSignatureGoalCount());
		if (petitionEntity.getPetitionSignatures() != null)
			petition.setSignatureCount(petitionEntity.getPetitionSignatures().size());
		System.err.println(petitionEntity);
		return petition;
	}

	public Petition getPetitionDetails(Integer petitionId) {

		return populatePetition(getPetitionEntityDetails(petitionId));

	}

	private PetitionEntity getPetitionEntityDetails(Integer petitionId) {
		return getPetitionRespository().findById(petitionId).get();
	}

	public PetitionSignatureRespository getPetitionSignatureRespository() {
		return petitionSignatureRespository;
	}

	public void setPetitionSignatureRespository(PetitionSignatureRespository petitionSignatureRespository) {
		this.petitionSignatureRespository = petitionSignatureRespository;
	}

	public void savePetitionSignature(PetitionSignature petitionSignature) {

		PetitionEntity petition = getPetitionEntityDetails(petitionSignature.getPetitionId());
		PetitionSignatureEntity petitionSignatureEntity = new PetitionSignatureEntity();
		petitionSignatureEntity.setName(petitionSignature.getName());
		petitionSignatureEntity.setEmail(petitionSignature.getEmail());
		java.sql.Timestamp currentDateTime = new java.sql.Timestamp(new java.util.Date().getTime());
		petitionSignatureEntity.setCreateDateTime(currentDateTime);
		petitionSignatureEntity.setPetition(petition);
		getPetitionSignatureRespository().save(petitionSignatureEntity);
	}

	
	public List<Petition> searchPetition(String petitionTitle) {
		
		List<Petition> petitionList = new ArrayList<Petition>();
		List<PetitionEntity> petitionEntities = getPetitionRespository().searchPeitionByTitle(petitionTitle);
		for (PetitionEntity petitionEntity : petitionEntities) {
			petitionList.add(populatePetition(petitionEntity));
		}
		return petitionList;
	}
}
