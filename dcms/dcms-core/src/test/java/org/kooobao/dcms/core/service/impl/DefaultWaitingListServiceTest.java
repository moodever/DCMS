package org.kooobao.dcms.core.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.kooobao.dcms.core.dao.MemoryChildDao;
import org.kooobao.dcms.core.dao.MemoryWaitingListDao;
import org.kooobao.dcms.core.entity.WaitingList;
import org.kooobao.dcms.core.entity.WaitingList.Status;
import org.kooobao.dcms.core.service.dto.NotifyWaitingListDto;
import org.kooobao.dcms.core.service.dto.NotifyWaitingListResultDto;

public class DefaultWaitingListServiceTest {

	private DefaultWaitingListService service;

	private MemoryChildDao childDao;

	private MemoryWaitingListDao waitingListDao;

	@Before
	public void prepare() {
		service = new DefaultWaitingListService();
		childDao = new MemoryChildDao();
		service.setChildDao(childDao);
		waitingListDao = new MemoryWaitingListDao();
		service.setWaitingListDao(waitingListDao);

		WaitingList wl1 = new WaitingList();
		wl1.setId(1);
		wl1.setStatus(Status.OFFERED);

		waitingListDao.save(wl1);
	}

	@Test
	public void testNotifyWaitingList() {
		NotifyWaitingListDto input = new NotifyWaitingListDto();
		input.setWaitingListID(1);
		input.setWaitingListStatus(Status.CONFIRMED.ordinal());
		NotifyWaitingListResultDto result = service.notifyWaitingList(input);

		assertTrue(result.isSuccess());

		WaitingList wl = waitingListDao.findById(1);

		assertEquals(Status.CONFIRMED, wl.getStatus());
		
	}

	@Test
	public void testSaveWaitingEntry() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteWaitingEntry() {
		fail("Not yet implemented");
	}

}
