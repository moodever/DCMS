package org.kooobao.dcms.core.dao.jpa;

import java.util.List;

import org.kooobao.common.dao.JpaDao;
import org.kooobao.dcms.core.dao.WaitingListDao;
import org.kooobao.dcms.core.entity.WaitingList;
import org.kooobao.dcms.core.entity.WaitingList.Status;

public class JpaWaitingListDao extends JpaDao<WaitingList> implements
		WaitingListDao {

	@Override
	public List<WaitingList> findValid() {
		String sql = "select wl from WaitingList wl where wl.status in (:active, :offer, :confirm)";
		return getEntityManager().createQuery(sql, WaitingList.class)
				.setParameter("active", Status.NEW)
				.setParameter("offer", Status.OFFERED)
				.setParameter("confirm", Status.CONTRACT_CONFIRMED).getResultList();
	}

}
