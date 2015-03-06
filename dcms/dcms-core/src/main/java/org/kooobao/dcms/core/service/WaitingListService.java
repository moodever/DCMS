package org.kooobao.dcms.core.service;

import org.kooobao.dcms.core.service.dto.DeleteWaitingEntryDto;
import org.kooobao.dcms.core.service.dto.DeleteWaitingEntryResultDto;
import org.kooobao.dcms.core.service.dto.FindWaitingListDto;
import org.kooobao.dcms.core.service.dto.FindWaitingListResultDto;
import org.kooobao.dcms.core.service.dto.NotifyWaitingListDto;
import org.kooobao.dcms.core.service.dto.NotifyWaitingListResultDto;
import org.kooobao.dcms.core.service.dto.SaveWaitingEntryDto;
import org.kooobao.dcms.core.service.dto.SaveWaitingEntryResultDto;

public interface WaitingListService {

	public SaveWaitingEntryResultDto saveWaitingEntry(SaveWaitingEntryDto input);

	public NotifyWaitingListResultDto notifyWaitingList(
			NotifyWaitingListDto input);

	public DeleteWaitingEntryResultDto deleteWaitingEntry(
			DeleteWaitingEntryDto input);

	public FindWaitingListResultDto findWaitingList(FindWaitingListDto input);
}
