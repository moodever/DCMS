package org.kooobao.dcms.core.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.kooobao.dcms.core.entity.WaitingList;

public class MemoryWaitingListDao extends MemoryDao<WaitingList> implements
		WaitingListDao {

	@Override
	public List<WaitingList> findValid() {
		return new ArrayList<WaitingList>();
	}
	
	@Override
	public List<WaitingList> findEnrolledChild() {
		return new ArrayList<WaitingList>();
	}
	
	@Override
	public WaitingList findByNameDob(String firstName,String lastName, Date dateBirth)
	{
		return new WaitingList();
	}
	
}

