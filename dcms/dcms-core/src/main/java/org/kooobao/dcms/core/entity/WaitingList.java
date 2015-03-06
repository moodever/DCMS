package org.kooobao.dcms.core.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;
import org.kooobao.common.dao.Entity;
import org.kooobao.common.dao.StatusEnumConverter;

@javax.persistence.Entity
@Table(name = "dcms_waitinglist")
@Converter(name = "statusConverter", converterClass = StatusEnumConverter.class)
public class WaitingList extends Entity {

	public static enum Status {
		ACTIVE, OFFERED, CONFIRMED, INVALID, RETURNED, REMOVED
	}

	@Column(name = "desire_date")
	@Temporal(TemporalType.DATE)
	private Date desireDate;

	@Column(name = "application_date")
	@Temporal(TemporalType.DATE)
	private Date applicationDate;

	@Column(name = "offered_date")
	@Temporal(TemporalType.DATE)
	private Date offeredDate;

	@Column(name = "status")
	@Convert("statusConverter")
	private Status status;

	@Column(name = "expect_grade")
	private int expectGrade;

	@Column(name = "note")
	private String note;

	@Column(name = "customized_sequence")
	private int customizedSequence;

	@Column(name = "attending_mode")
	private String attendingMode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "child")
	private Child child;

	public String getAttendingMode() {
		return attendingMode;
	}

	public void setAttendingMode(String attendingMode) {
		this.attendingMode = attendingMode;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public void setNote(String note) {
		this.note = note;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getExpectGrade() {
		return expectGrade;
	}

	public void setExpectGrade(int expectGrade) {
		this.expectGrade = expectGrade;
	}

	public Date getOfferedDate() {
		return offeredDate;
	}

	public void setOfferedDate(Date offeredDate) {
		this.offeredDate = offeredDate;
	}

	public int getCustomizedSequence() {
		return customizedSequence;
	}

	public void setCustomizedSequence(int customizedSequence) {
		this.customizedSequence = customizedSequence;
	}

	public String getNote() {
		return note;
	}

}
