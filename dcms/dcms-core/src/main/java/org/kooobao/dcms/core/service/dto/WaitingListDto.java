package org.kooobao.dcms.core.service.dto;

import java.util.Date;

public class WaitingListDto {

	private int id;

	private String name;

	private Date dateOfBirth;

	private int affiliation;

	private String status;
	

	private String displayStatus;

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(int affiliation) {
		this.affiliation = affiliation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDisplayStatus() {
		return displayStatus;
	}

	public void setDisplayStatus(String displayStatus) {
		this.displayStatus = displayStatus;
	}


}
