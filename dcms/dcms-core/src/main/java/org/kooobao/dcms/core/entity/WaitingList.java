package org.kooobao.dcms.core.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.kooobao.common.dao.Entity;

@javax.persistence.Entity
@Table(name = "dcms_waitinglist")
public class WaitingList extends Entity {

	
	/*
	New, Keep on List, Returned to List -> (New)
	Offered -> (Offered)
	Accepted -> (Accepted)
	No Response, Declined -> (Declined)
	Removed -> (Removed)
	Contract Confirmed -> Confirmed
	Enrolled -> Enrolled
	
	*/
	
	public static enum Status {
		NEW, OFFERED, ACCEPTED, DECLINED, REMOVED, CONTRACT_CONFIRMED, ENROLLED
	}

	public static enum DisplayStatus {
		NEW, KEEP_ON_LIST, RETURNED_TO_LIST,OFFERED,ACCEPTED,NO_RESPONSE,DECLINED,REMOVED,CONTRACT_CONFIRMED,ENROLLED
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
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "display_status")
	@Enumerated(EnumType.STRING)
	private DisplayStatus displayStatus;

	@Column(name = "expect_grade")
	private String expectGrade;

	@Column(name = "note")
	private String note;

	@Column(name = "customized_sequence")
	private int customizedSequence;

	@Column(name = "attending_mode")
	@Enumerated(EnumType.STRING)
	private AttendingMode attendingMode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "child")
	private Child child;

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

	public String getExpectGrade() {
		return expectGrade;
	}

	public void setExpectGrade(String expectGrade) {
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

	public DisplayStatus getDisplayStatus() {
		return displayStatus;
	}

	public void setDisplayStatus(DisplayStatus displayStatus) {
		this.displayStatus = displayStatus;
	}
	
	public static Status getMatchedStatus(DisplayStatus displayStatus){
		
		
		if(displayStatus == DisplayStatus.NEW){
			return Status.NEW;
		}
		
		if(displayStatus == DisplayStatus.KEEP_ON_LIST){
			return Status.NEW;
		}
		
		if(displayStatus == DisplayStatus.RETURNED_TO_LIST){
			return Status.NEW;
		}
		if(displayStatus == DisplayStatus.OFFERED){
			return Status.OFFERED;
		}
		
		if(displayStatus == DisplayStatus.ACCEPTED){
			return Status.ACCEPTED;
		}
		
		if(displayStatus == DisplayStatus.DECLINED){
			return Status.DECLINED;
		}
		
		if(displayStatus == DisplayStatus.NO_RESPONSE){
			return Status.DECLINED;
		}
		
		
		if(displayStatus == DisplayStatus.REMOVED){
			return Status.REMOVED;
		}
		
		if(displayStatus == DisplayStatus.CONTRACT_CONFIRMED){
			return Status.CONTRACT_CONFIRMED;
		}
		
		if(displayStatus == DisplayStatus.ENROLLED){
			return Status.ENROLLED;
		}
		
		return null;
		
		
	}

}
