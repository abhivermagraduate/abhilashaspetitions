package com.nui.model;


import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class Petition {

	private String name;
	private String email;
	private String petitionText;
	private Integer id;
    private MultipartFile imageFile;
    private String imageId;
    private String petitionTitle;
    private String petitionScope;
    private String geographicArea;
	private Timestamp createDateTime;
	private Integer signatureCount =0;
	private Integer signatureGoalCount;

	
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
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
	public Timestamp getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}
	public Integer getSignatureCount() {
		return signatureCount;
	}
	public void setSignatureCount(Integer signatureCount) {
		this.signatureCount = signatureCount;
	}
	public Integer getSignatureGoalCount() {
		return signatureGoalCount;
	}
	public void setSignatureGoalCount(Integer signatureGoalCount) {
		this.signatureGoalCount = signatureGoalCount;
	}
	
}
