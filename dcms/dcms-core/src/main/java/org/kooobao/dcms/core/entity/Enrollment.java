package org.kooobao.dcms.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;
import org.kooobao.common.dao.ERStatusEnumConverter;
import org.kooobao.common.dao.Entity;

@javax.persistence.Entity
@Table(name = "dcms_enrollment")
@Converter(name = "statusConverter", converterClass = ERStatusEnumConverter.class)
public class Enrollment extends Entity {

	public static enum Status {
		WAITCONFIRM, WAITCONTRACT, EFFECTIVE, OLD, INVALID, REFUSED
	}

	@Column(name = "status")
	@Convert("statusConverter")
	private Status status;

	@Column(name = "term")
	private String term;

	@Column(name = "contract_from_date")
	@Temporal(TemporalType.DATE)
	private Date contractFrom;

	@Column(name = "contract_to_date")
	@Temporal(TemporalType.DATE)
	private Date contractTo;

	@Column(name = "accept_date")
	@Temporal(TemporalType.DATE)
	private Date acceptDate;

	@Column(name = "contract_from")
	@Temporal(TemporalType.DATE)
	private Date firstDate;

	@Column(name = "attending_mode")
	private String attendingMode;

	@OneToOne
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;

	@OneToOne
	@JoinColumn(name = "child_id")
	private Child child;

	@Embedded
	private TimeSheet timeSheet;

	public String getAttendingMode() {
		return attendingMode;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public TimeSheet getTimeSheet() {
		return timeSheet;
	}

	public void setTimeSheet(TimeSheet timeSheet) {
		this.timeSheet = timeSheet;
	}

	public void setAttendingMode(String attendingMode) {
		this.attendingMode = attendingMode;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Date getContractFrom() {
		return contractFrom;
	}

	public void setContractFrom(Date contractFrom) {
		this.contractFrom = contractFrom;
	}

	public Date getContractTo() {
		return contractTo;
	}

	public void setContractTo(Date contractTo) {
		this.contractTo = contractTo;
	}

	public Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

}
