package com.nui.entity;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class PetitionEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	private String name;
	private String email;
	private String petitionText;
	private Date createDateTime;
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
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	
	

}
