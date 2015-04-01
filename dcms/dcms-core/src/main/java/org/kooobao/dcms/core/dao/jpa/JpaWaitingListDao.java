package org.kooobao.dcms.core.dao.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.kooobao.common.dao.JpaDao;
import org.kooobao.dcms.core.dao.WaitingListDao;
import org.kooobao.dcms.core.entity.WaitingList;
import org.kooobao.dcms.core.entity.WaitingList.Status;

public class JpaWaitingListDao extends JpaDao<WaitingList> implements
		WaitingListDao {

	@Override
	public List<WaitingList> findValid() {
		String sql = "select wl from WaitingList wl where wl.status in"
				+ " (:active, :offer, :confirm, :accepted, :declined, :enrolled, :removed)";
		return getEntityManager().createQuery(sql, WaitingList.class)
				.setParameter("active", Status.NEW)
				.setParameter("offer", Status.OFFERED)
				.setParameter("confirm", Status.CONTRACT_CONFIRMED) 
				.setParameter("accepted",Status.ACCEPTED)
				.setParameter("declined", Status.DECLINED)
				.setParameter("enrolled", Status.ENROLLED)
				.setParameter("removed",Status.REMOVED )
				.getResultList();
		
	}
	
	@Override
	public List<WaitingList> findEnrolledChild() {
		String sql = "select wl from WaitingList wl where wl.status in"
				+ " (:confirm, :enrolled)";
		return getEntityManager().createQuery(sql, WaitingList.class)
				.setParameter("confirm", Status.CONTRACT_CONFIRMED) 
				.setParameter("enrolled", Status.ENROLLED)
				.getResultList();
		
	}
	
	
	



	@Override
	public WaitingList findByNameDob(String tFirstName, String tLastName,
			Date tDateBirth) {
		String sql = "select wl from WaitingList wl "
				+ "where wl.child.firstName = :firstName "
				+ "and wl.child.lastName = :lastName "
				+ "and wl.child.dob = :dob";
		try {
			return getEntityManager().createQuery(sql, WaitingList.class)
					.setParameter("firstName", tFirstName)
					.setParameter("lastName", tLastName)
					.setParameter("dob", tDateBirth).getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

}
