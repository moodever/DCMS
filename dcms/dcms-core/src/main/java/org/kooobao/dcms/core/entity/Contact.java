package org.kooobao.dcms.core.entity;

import java.text.MessageFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.kooobao.common.dao.Entity;

import com.mysql.jdbc.StringUtils;

@Embeddable
public class Contact extends Entity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "status")
	private String status;

	@Column(name = "role")
	private String role;

	@Column(name = "email")
	private String email;

	@Column(name = "phone1")
	private String phone1;

	@Column(name = "phone2")
	private String phone2;

	@Column(name = "address")
	private String address;

	@Column(name = "note")
	private String note;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getName() {
		if (StringUtils.isEmptyOrWhitespaceOnly(getMiddleName())) {
			return MessageFormat.format("{0} {1}", getFirstName(),
					getLastName());
		} else {
			return MessageFormat.format("{0} {1}. {2}", getFirstName(),
					Character.toUpperCase(getMiddleName().charAt(0)),
					getLastName());
		}
	}
}
