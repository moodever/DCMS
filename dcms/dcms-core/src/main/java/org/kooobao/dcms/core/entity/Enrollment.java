package org.kooobao.dcms.core.entity;

import java.util.Date;

import org.kooobao.common.dao.Entity;

public class Enrollment extends Entity {
	
	public static int STATUS_WAITCONFIRM = 0;
	public static int STATUS_WAITCONTRACT = 1;
	public static int STATUS_EFFECTIVE = 2;
	public static int STATUS_VOID=3;
	
	private int status;
	private String term;
	private Date contractFrom;
	private Date contractTo;
	private Date acceptDate;
	private Date firstDate;
	private Classroom classroom;
	
	private String attendingMode;
	private Child child;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
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
