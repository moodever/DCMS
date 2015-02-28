package org.kooobao.dcms.core.entity;

import java.util.Date;
import java.util.List;

import org.kooobao.common.dao.Entity;

public class Child extends Entity {

	private String firstName;
	private String middleName;
	private String lastName;
	private String Phone;

	private Date dateBirth;

	private int sliblingId;

	private int affliation;

	private String note;

	private List<Contact> contacts;

	private List<Enrollment> enrollments;

	private Enrollment activeEnrollment;
	


	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Enrollment getActiveEnrollment() {
		return activeEnrollment;
	}

	public void setActiveEnrollment(Enrollment activeEnrollment) {
		this.activeEnrollment = activeEnrollment;
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

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

}
