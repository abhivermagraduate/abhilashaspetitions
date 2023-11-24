/**
 * @author Abhilasha Verma
 * Email : A.Verma7@nuigalway.ie 
 * Student Number : 22102028
 */
package com.nui.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * This entity class is mapped with petition_signature table.
 */
@Entity
@Table(name = "petition_signature")
public class PetitionSignatureEntity {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "create_date_time")
	private Timestamp createDateTime;

	@Column(name = "petition_win_notification")
	private Boolean petitionWinNotificationStatus;

	@Column(name = "petition_progress_notification")
	private Boolean petitionProgressNotificationStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	private PetitionEntity petition;

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

	public PetitionEntity getPetition() {
		return petition;
	}

	public void setPetition(PetitionEntity petition) {
		this.petition = petition;
	}

	

}
