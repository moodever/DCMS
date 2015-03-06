package org.kooobao.dcms.core.dao.jpa;

import java.util.List;

import org.kooobao.common.dao.JpaDao;
import org.kooobao.dcms.core.dao.WaitingListDao;
import org.kooobao.dcms.core.entity.WaitingList;

public class JpaWaitingListDao extends JpaDao<WaitingList> implements
		WaitingListDao {

	@Override
	public List<WaitingList> findValid() {
		String sql = "select wl from WaitingList wl where wl.status in ('ACTIVE', 'OFFERED', 'CONFIRMED')";
		return getEntityManager().createQuery(sql, WaitingList.class)
				.getResultList();
	}

}
