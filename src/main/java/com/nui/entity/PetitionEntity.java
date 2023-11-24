/**
 * @author Abhilasha Verma
 * Email : A.Verma7@nuigalway.ie 
 * Student Number : 22102028
 */
package com.nui.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * This entity class is mapped with petition table.
 */
@Entity
@Table(name = "petition")
public class PetitionEntity {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;

	@Column(name = "create_date_time")
	private Timestamp createDateTime;

	@Column(name = "petition_text")

	private String petitionText;

	@Column(name = "image_id")
	private String imageId;

	@Column(name = "petition_title")
	private String petitionTitle;

	@Column(name = "petition_scope")
	private String petitionScope;

	@Column(name = "geographic_area")
	private String geographicArea;
	
	@Column(name = "signature_goal_count")
	private Integer signatureGoalCount;


	@OneToMany(mappedBy = "petition", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PetitionSignatureEntity> petitionSignatures = new ArrayList<>();

	public List<PetitionSignatureEntity> getPetitionSignatures() {
		return petitionSignatures;
	}

	public void setPetitionSignatures(List<PetitionSignatureEntity> petitionSignatures) {
		this.petitionSignatures = petitionSignatures;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPetitionText() {
		return petitionText;
	}

	public void setPetitionText(String petitionText) {
		this.petitionText = petitionText;
	}

	public Timestamp getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getPetitionTitle() {
		return petitionTitle;
	}

	public void setPetitionTitle(String petitionTitle) {
		this.petitionTitle = petitionTitle;
	}

	public String getPetitionScope() {
		return petitionScope;
	}

	public void setPetitionScope(String petitionScope) {
		this.petitionScope = petitionScope;
	}

	public String getGeographicArea() {
		return geographicArea;
	}

	public void setGeographicArea(String geographicArea) {
		this.geographicArea = geographicArea;
	}

	public Integer getSignatureGoalCount() {
		return signatureGoalCount;
	}

	public void setSignatureGoalCount(Integer signatureGoalCount) {
		this.signatureGoalCount = signatureGoalCount;
	}

	@Override
	public String toString() {
		return "PetitionEntity [id=" + id + ", name=" + name + ", email=" + email + ", createDateTime=" + createDateTime
				+ ", petitionText=" + petitionText + ", imageId=" + imageId + ", petitionTitle=" + petitionTitle
				+ ", petitionScope=" + petitionScope + ", geographicArea=" + geographicArea + ", signatureGoalCount="
				+ signatureGoalCount + ", petitionSignatures=" + petitionSignatures + ", getPetitionSignatures()="
				+ getPetitionSignatures() + ", getId()=" + getId() + ", getName()=" + getName() + ", getEmail()="
				+ getEmail() + ", getPetitionText()=" + getPetitionText() + ", getCreateDateTime()="
				+ getCreateDateTime() + ", getImageId()=" + getImageId() + ", getPetitionTitle()=" + getPetitionTitle()
				+ ", getPetitionScope()=" + getPetitionScope() + ", getGeographicArea()=" + getGeographicArea()
				+ ", getSignatureGoalCount()=" + getSignatureGoalCount() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
