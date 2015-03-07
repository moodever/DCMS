package org.kooobao.dcms.core.service.dto;

import java.util.Date;

import org.kooobao.dcms.core.dto.Dto;

public class SaveWaitingEntryDto extends Dto {

	private int waitingListID = -1;
	private int childID = -1;

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

	private Date desireDate;
	private Date applicationDate;
	private Date offeredDate;
	private int status;
	private int expectGrade;
	private String note;
	private int customizedSequence;
	private String attendingMode;

	private String childFirstName;
	private String childMiddleName;
	private String childLastName;
	private Date childDateBirth;
	private String Phone;
	private int sliblingId;
	private int affliation;
	private String childNote;

	private ContactDto[] contacts;

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

	public int getExpectGrade() {
		return expectGrade;
	}

	public void setExpectGrade(int expectGrade) {
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

	public String getAttendingMode() {
		return attendingMode;
	}

	public void setAttendingMode(String attendingMode) {
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

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public int getSliblingId() {
		return sliblingId;
	}

	public void setSliblingId(int sliblingId) {
		this.sliblingId = sliblingId;
	}

	public int getAffliation() {
		return affliation;
	}

	public void setAffliation(int affliation) {
		this.affliation = affliation;
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

}
