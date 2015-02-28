package org.kooobao.dcms.core.entity;

import java.util.Date;

import org.kooobao.common.dao.Entity;

public class WaitingList extends Entity {

	public static enum Status {
		ACTIVE, OFFERED, CONFIRMED, INVALID, RETURNED
	}

	private Date desireDate;
	private Date applicationDate;
	private Date offeredDate;
	private Status status;
	private int expectGrade;
	private String note;
	private Child child;
	private int customizedSequence;
	private String attendingMode;

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
