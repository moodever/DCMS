package org.kooobao.dcms.core.service.dto;

import java.util.Date;

import org.kooobao.dcms.core.dto.Dto;

public class WaitingListDto extends Dto{

	private int id;

	private String name;

	private Date dateOfBirth;

	private int affiliation;

	private String status;

	private String displayStatus;
	
	private String phone;
	
	private Date applicationDate;
	
	private Date desireDate;
	
	private String expectGrade;
	
	private String attendingMode;
	
	private String firstParentName;
	private String firstParentRole;
	private String firstParentStatus;
	
	private String secondParentName;
	private String secondParentRole;
	private String secondParentStatus;
	
	private String note;
	

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Date getDesireDate() {
		return desireDate;
	}

	public void setDesireDate(Date desireDate) {
		this.desireDate = desireDate;
	}

	public String getExpectGrade() {
		return expectGrade;
	}

	public void setExpectGrade(String expectGrade) {
		this.expectGrade = expectGrade;
	}

	public String getAttendingMode() {
		return attendingMode;
	}

	public void setAttendingMode(String attendingMode) {
		this.attendingMode = attendingMode;
	}

	public String getFirstParentName() {
		return firstParentName;
	}

	public void setFirstParentName(String firstParentName) {
		this.firstParentName = firstParentName;
	}

	public String getFirstParentRole() {
		return firstParentRole;
	}

	public void setFirstParentRole(String firstParentRole) {
		this.firstParentRole = firstParentRole;
	}

	public String getFirstParentStatus() {
		return firstParentStatus;
	}

	public void setFirstParentStatus(String firstParentStatus) {
		this.firstParentStatus = firstParentStatus;
	}

	public String getSecondParentName() {
		return secondParentName;
	}

	public void setSecondParentName(String secondParentName) {
		this.secondParentName = secondParentName;
	}

	public String getSecondParentRole() {
		return secondParentRole;
	}

	public void setSecondParentRole(String secondParentRole) {
		this.secondParentRole = secondParentRole;
	}

	public String getSecondParentStatus() {
		return secondParentStatus;
	}

	public void setSecondParentStatus(String secondParentStatus) {
		this.secondParentStatus = secondParentStatus;
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
