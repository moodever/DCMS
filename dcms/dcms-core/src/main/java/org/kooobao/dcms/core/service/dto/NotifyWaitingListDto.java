package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.Dto;
import org.kooobao.dcms.core.entity.WaitingList.Status;

public class NotifyWaitingListDto extends Dto {

	private int waitingListID;
	// private int childID;

	private String waitingListStatus;

	public int getWaitingListID() {
		return waitingListID;
	}

	public String getWaitingListStatus() {
		return waitingListStatus;
	}

	public void setWaitingListStatus(String waitingListStatus) {
		this.waitingListStatus = waitingListStatus;
	}

	public void setWaitingListID(int waitingListID) {
		this.waitingListID = waitingListID;
	}

	public Status getWaitingListStatusEnum() {
		return Status.valueOf(waitingListStatus);
	}
}
