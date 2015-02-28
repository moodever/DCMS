package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.Dto;

public class NotifyWaitingListDto extends Dto {
	
	private int waitingListID;
	//private int childID;
	
	private int waitingListStatus; 

	public int getWaitingListID() {
		return waitingListID;
	}

	public int getWaitingListStatus() {
		return waitingListStatus;
	}

	public void setWaitingListStatus(int waitingListStatus) {
		this.waitingListStatus = waitingListStatus;
	}

	public void setWaitingListID(int waitingListID) {
		this.waitingListID = waitingListID;
	}

}
