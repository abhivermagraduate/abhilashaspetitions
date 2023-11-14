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
	
	
	@OneToMany(
	        mappedBy = "petition",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
    private List<PetitionSignatureEntity> comments = new ArrayList<>();

	

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

}
