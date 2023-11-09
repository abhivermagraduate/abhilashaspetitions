package com.nui.model;

import java.util.Date;

public class Petition {

	private String name;
	private String email;
	private String petitionText;
	
	
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
	@Override
	public String toString() {
		return "Petition [name=" + name + ", email=" + email + ", petitionText=" + petitionText + "]";
	}

}
