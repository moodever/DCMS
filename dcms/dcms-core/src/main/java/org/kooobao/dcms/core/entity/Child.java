package org.kooobao.dcms.core.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.kooobao.common.dao.Entity;

@javax.persistence.Entity
@Table(name = "dcms_child")
public class Child extends Entity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	private Date dateBirth;

	@Column(name = "slibling_id")
	private int sliblingId;

	@Column(name = "affliation")
	private int affliation;

	@Column(name = "note")
	private String note;

	@ElementCollection
	@CollectionTable(name = "dcms_child_contact", joinColumns = { @JoinColumn(name = "child_id") })
	private List<Contact> contacts;

	@OneToMany(mappedBy = "child", orphanRemoval = true)
	private List<Enrollment> enrollments;

	@OneToOne
	@JoinColumn(name = "active_enrollment")
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
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
