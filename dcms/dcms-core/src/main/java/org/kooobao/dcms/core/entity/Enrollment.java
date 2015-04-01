package org.kooobao.dcms.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Converter;
import org.kooobao.common.dao.ERStatusEnumConverter;
import org.kooobao.common.dao.Entity;

@javax.persistence.Entity
@Table(name = "dcms_enrollment")
@Converter(name = "statusConverter", converterClass = ERStatusEnumConverter.class)
public class Enrollment extends Entity {

	public static enum Status {
		PREPARE, EFFECTIVE,INVALID,EXPIRED
	}

	/*
	 * WaitingList Status
	 * 
	 * public static enum Status { NEW, OFFERED, ACCEPTED, DECLINED, REMOVED,
	 * CONTRACT_CONFIRMED, ENROLLED}
	 * 
	 * public static enum DisplayStatus { NEW, KEEP_ON_LIST,
	 * RETURNED_TO_LIST,OFFERED
	 * ,ACCEPTED,NO_RESPONSE,DECLINED,REMOVED,CONTRACT_CONFIRMED,ENROLLED }
	 */

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

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
	@Enumerated(EnumType.STRING)
	private AttendingMode attendingMode;
	
	@OneToOne
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;

	@OneToOne
	@JoinColumn(name = "child_id")
	private Child child;

	@Embedded
	private TimeSheet timeSheet;

	public AttendingMode getAttendingMode() {
		return attendingMode;
	}
	
	public void setAttendingMode(AttendingMode attendingMode) {
		this.attendingMode = attendingMode;
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
