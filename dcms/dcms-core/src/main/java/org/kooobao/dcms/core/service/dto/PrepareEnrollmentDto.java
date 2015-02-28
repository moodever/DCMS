package org.kooobao.dcms.core.service.dto;

import java.util.Date;

import org.kooobao.dcms.core.dto.Dto;
import org.kooobao.dcms.core.entity.Classroom;

public class PrepareEnrollmentDto extends Dto{
	
	
	private String term;
	private Date contractFrom;
	private Date contractTo;
	private Classroom classroom;
	private String attendingMode;
	private int waitingListId;

	
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
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public String getAttendingMode() {
		return attendingMode;
	}
	public void setAttendingMode(String attendingMode) {
		this.attendingMode = attendingMode;
	}
	public int getWaitingListId() {
		return waitingListId;
	}
	public void setWaitingListId(int waitingListID) {
		this.waitingListId = waitingListID;
	}
	

}
