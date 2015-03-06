package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.ResultDto;

public class FindWaitingListResultDto extends ResultDto {

	private WaitingListDto[] waitingLists;

	public WaitingListDto[] getWaitingLists() {
		return waitingLists;
	}

	public void setWaitingLists(WaitingListDto[] waitingLists) {
		this.waitingLists = waitingLists;
	}

}
