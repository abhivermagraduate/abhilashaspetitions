package com.nui.model;

import java.sql.Timestamp;

public class PetitionSignature {

	private int id;

	private String name;

	private String email;

	private Timestamp createDateTime;

	private Boolean petitionWinNotificationStatus;

	private Boolean petitionProgressNotificationStatus;

	private int petitionId;

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

	public Timestamp getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Boolean getPetitionWinNotificationStatus() {
		return petitionWinNotificationStatus;
	}

	public void setPetitionWinNotificationStatus(Boolean petitionWinNotificationStatus) {
		this.petitionWinNotificationStatus = petitionWinNotificationStatus;
	}

	public Boolean getPetitionProgressNotificationStatus() {
		return petitionProgressNotificationStatus;
	}

	public void setPetitionProgressNotificationStatus(Boolean petitionProgressNotificationStatus) {
		this.petitionProgressNotificationStatus = petitionProgressNotificationStatus;
	}

	public int getPetitionId() {
		return petitionId;
	}

	public void setPetitionId(int petitionId) {
		this.petitionId = petitionId;
	}

	@Override
	public String toString() {
		return "PetitionSignature [id=" + id + ", name=" + name + ", email=" + email + ", createDateTime="
				+ createDateTime + ", petitionWinNotificationStatus=" + petitionWinNotificationStatus
				+ ", petitionProgressNotificationStatus=" + petitionProgressNotificationStatus + ", petitionId="
				+ petitionId + "]";
	}
	
	
	
}
