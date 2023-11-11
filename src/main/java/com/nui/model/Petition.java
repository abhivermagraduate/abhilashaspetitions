package com.nui.model;


import org.springframework.web.multipart.MultipartFile;

public class Petition {

	private String name;
	private String email;
	private String petitionText;
	private Integer id;
    private MultipartFile imageFile;

	
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
	
	

}
