package org.kooobao.dcms.core.entity;

import java.text.MessageFormat;
import java.util.ArrayList;
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

import com.mysql.jdbc.StringUtils;

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

	public Child() {
		this.enrollments = new ArrayList<Enrollment>();
	}

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

	// Always return the first Enrollment with the specified status
	public Enrollment getEnrollment(Enrollment.Status status) {
		for (Enrollment enrollment : this.enrollments) {
			if (enrollment.getStatus() == status)
				return enrollment;
		}
		return null;
	}

	public Enrollment getActiveEnrollment() {
		return activeEnrollment;
	}

	public void setActiveEnrollment(Enrollment activeEnrollment) {
		this.activeEnrollment = activeEnrollment;
	}

	public void removeEnrollment(Enrollment e) {

		if (getActiveEnrollment() != null && getActiveEnrollment().equals(e)) {
			setActiveEnrollment(null);
		}
		e.getClassroom().removeEnrollment(e);

		getEnrollments().remove(e);
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

	public String getName() {
		if (StringUtils.isEmptyOrWhitespaceOnly(getMiddleName())) {
			return MessageFormat.format("{0} {1}", getFirstName(),
					getLastName());
		} else {
			return MessageFormat.format("{0} {1} {2}", getFirstName(),
					getMiddleName(), getLastName());
		}
	}

}
