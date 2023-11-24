package com.nui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nui.dao.PetitionRespository;
import com.nui.dao.PetitionSignatureRespository;
import com.nui.entity.PetitionEntity;
import com.nui.entity.PetitionSignatureEntity;
import com.nui.model.Petition;
import com.nui.model.PetitionSignature;
/**
 * Purpose of this PetitionService class is to allow Create Petition,Show all Petitions,Petition detail and Search Petition
 *  
 */
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

	/**
	 * Purpose of this method to create PetitionEntity and set values from Petition object.
	 * @param petition
	 */
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

	/**
	 * Purpose of this method is to fetch all petitions by calling DAO layer PetitionRespository.findAll() then convert PetitionEntity into Petition object.
	 * @param model
	 * @return view
	 */
	public List<Petition> getPetitions() {
		List<Petition> petitionList = new ArrayList<Petition>();
		List<PetitionEntity> petitionEntities = getPetitionRespository().findAll();
		for (PetitionEntity petitionEntity : petitionEntities) {
			petitionList.add(populatePetition(petitionEntity));
		}
		return petitionList;
	}

	/**
	 * Purpose of this method convert PetitionEntity into Petition object.
	 * @param petitionEntity
	 * @return petition
	 */
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
		return petition;
	}

	/**
	 * Purpose of this method is to get details of individual petition by internally calling getPetitionRespository().findById() method. 
	 * then convert PetitionEntity into Petition object by calling populatePetition method.
	 * @param petitionId
	 * @return petition
	 */
	public Petition getPetitionDetails(Integer petitionId) {
		return populatePetition(getPetitionEntityDetails(petitionId));
	}

	/**
	 * Purpose of this getPetitionEntityDetails is to fetch petition record by petition id.
	 * @param petitionId
	 * @return petitionEntity
	 */
	private PetitionEntity getPetitionEntityDetails(Integer petitionId) {
		return getPetitionRespository().findById(petitionId).get();
	}

	/**
	 * Getter method to reurn  petitionSignatureRespository
	 * @return petitionSignatureRespository
	 */
	public PetitionSignatureRespository getPetitionSignatureRespository() {
		return petitionSignatureRespository;
	}

	/**
	 * Setter method to set petitionSignatureRespository
	 * @param petitionSignatureRespository
	 */
	public void setPetitionSignatureRespository(PetitionSignatureRespository petitionSignatureRespository) {
		this.petitionSignatureRespository = petitionSignatureRespository;
	}

	/**
	 * Purpose of this method to insert PetitionSignature data into database table by calling getPetitionSignatureRespository().save method
	 * @param petitionSignature
	 */
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

	/**
	 * Purpose of this method to search petition by title.
	 * @param petitionTitle
	 * @return list of Petition
	 */
	public List<Petition> searchPetition(String petitionTitle) {
		
		List<Petition> petitionList = new ArrayList<Petition>();
		List<PetitionEntity> petitionEntities = getPetitionRespository().searchPeitionByTitle(petitionTitle);
		for (PetitionEntity petitionEntity : petitionEntities) {
			petitionList.add(populatePetition(petitionEntity));
		}
		return petitionList;
	}
}
