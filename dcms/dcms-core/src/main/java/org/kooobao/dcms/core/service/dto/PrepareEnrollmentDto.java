package org.kooobao.dcms.core.service.dto;

import java.util.Date;

import org.kooobao.dcms.core.dto.Dto;

public class PrepareEnrollmentDto extends Dto {

	private String term;
	private Date contractFrom;
	private Date contractTo;
	private String classroomName;
	private int attendingMode;
	private int waitingListId;
	private String monTime;
	private String tueTime;
	private String wedTime;
	private String thuTime;
	private String friTime;
	private Date acceptDate;

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

	public String getClassroomName() {
		return classroomName;
	}

	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

	public int getAttendingMode() {
		return attendingMode;
	}

	public void setAttendingMode(int attendingMode) {
		this.attendingMode = attendingMode;
	}

	public int getWaitingListId() {
		return waitingListId;
	}

	public void setWaitingListId(int waitingListID) {
		this.waitingListId = waitingListID;
	}

	public String getMonTime() {
		return monTime;
	}

	public void setMonTime(String monTime) {
		this.monTime = monTime;
	}

	public String getTueTime() {
		return tueTime;
	}

	public void setTueTime(String tueTime) {
		this.tueTime = tueTime;
	}

	public String getWedTime() {
		return wedTime;
	}

	public void setWedTime(String wedTime) {
		this.wedTime = wedTime;
	}

	public String getThuTime() {
		return thuTime;
	}

	public void setThuTime(String thuTime) {
		this.thuTime = thuTime;
	}

	public String getFriTime() {
		return friTime;
	}

	public void setFriTime(String friTime) {
		this.friTime = friTime;
	}

	public Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

}
