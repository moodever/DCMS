package org.kooobao.dcms.core.service.dto;

import java.util.Date;

public class KidsChartNodeDto {

	String firstName;
	String lastName;
	String monday;
	String tuesday;
	String wednesday;
	String thursday;
	String friday;
	Date dateOfBirth;
	int affiliation;
	String notes;
	int sequenceNum;
	String attendingMode;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getSequenceNum() {
		return sequenceNum;
	}

	public void setSequenceNum(int sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public int getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(int affiliation) {
		this.affiliation = affiliation;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAttendingMode() {
		return attendingMode;
	}

	public void setAttendingMode(String attendingMode) {
		this.attendingMode = attendingMode;
	}

}