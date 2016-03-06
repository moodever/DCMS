package org.kooobao.dcms.core.service.dto;

import java.util.Date;

import org.kooobao.dcms.core.dto.Dto;

public class SaveWaitingEntryDto extends Dto {

	private int waitingListID = -1;
	private int childID = -1;

	private Date desireDate;
	private Date applicationDate;
	private Date offeredDate;
	private int status;
	private int displayStatus;
	private String expectGrade;
	private String note;
	private int customizedSequence;
	private int attendingMode;


	private String childFirstName;
	private String childMiddleName;
	private String childLastName;
	private Date childDateBirth;
	private int sliblingId;
	private int affiliation;
	private String phone;
	

	private String childNote;

	private ContactDto[] contacts;

	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public int getChildID() {
		return childID;
	}

	public void setChildID(int childID) {
		this.childID = childID;
	}

	public int getWaitingListID() {
		return waitingListID;
	}

	public void setWaitingListID(int waitingListID) {
		this.waitingListID = waitingListID;
	}
	
	public Date getDesireDate() {
		return desireDate;
	}

	public void setDesireDate(Date desireDate) {
		this.desireDate = desireDate;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Date getOfferedDate() {
		return offeredDate;
	}

	public void setOfferedDate(Date offeredDate) {
		this.offeredDate = offeredDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getExpectGrade() {
		return this.expectGrade;
	}

	public void setExpectGrade(String expectGrade) {
		this.expectGrade = expectGrade;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getCustomizedSequence() {
		return customizedSequence;
	}

	public void setCustomizedSequence(int customizedSequence) {
		this.customizedSequence = customizedSequence;
	}

	public int getAttendingMode() {
		return attendingMode;
	}

	public void setAttendingMode(int attendingMode) {
		this.attendingMode = attendingMode;
	}

	public String getChildFirstName() {
		return childFirstName;
	}

	public void setChildFirstName(String childFirstName) {
		this.childFirstName = childFirstName;
	}

	public String getChildMiddleName() {
		return childMiddleName;
	}

	public void setChildMiddleName(String childMiddleName) {
		this.childMiddleName = childMiddleName;
	}

	public String getChildLastName() {
		return childLastName;
	}

	public void setChildLastName(String childLastName) {
		this.childLastName = childLastName;
	}

	public Date getChildDateBirth() {
		return childDateBirth;
	}

	public void setChildDateBirth(Date childDateBirth) {
		this.childDateBirth = childDateBirth;
	}

	public int getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(int affiliation) {
		this.affiliation = affiliation;
	}

	public int getSliblingId() {
		return sliblingId;
	}

	public void setSliblingId(int sliblingId) {
		this.sliblingId = sliblingId;
	}

	public int getAffliation() {
		return affiliation;
	}

	public void setAffliation(int affiliation) {
		this.affiliation = affiliation;
	}

	public String getChildNote() {
		return childNote;
	}

	public void setChildNote(String childNote) {
		this.childNote = childNote;
	}

	public ContactDto[] getContacts() {
		return contacts;
	}

	public void setContacts(ContactDto[] contacts) {
		this.contacts = contacts;
	}

	public int getDisplayStatus() {
		return displayStatus;
	}

	public void setDisplayStatus(int displayStatus) {
		this.displayStatus = displayStatus;
	}
	


}
