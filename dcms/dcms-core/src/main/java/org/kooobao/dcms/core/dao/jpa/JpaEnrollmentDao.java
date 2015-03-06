package org.kooobao.dcms.core.dao.jpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.kooobao.common.dao.JpaDao;
import org.kooobao.dcms.core.dao.EnrollmentDao;
import org.kooobao.dcms.core.entity.Enrollment;
import org.kooobao.dcms.core.entity.Enrollment.Status;

public class JpaEnrollmentDao extends JpaDao<Enrollment> implements
		EnrollmentDao {

	@Override
	public Enrollment findByStatus(Status status, int childId) {
		String sql = "select e from Enrollment e where e.status = :status and e.child.id = :childId";
		try {
			return getEntityManager().createQuery(sql, Enrollment.class)
					.setParameter("status", status)
					.setParameter("childId", childId).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Enrollment> findByStatus(Status effective) {
		String sql = "select e from Enrollment e where e.status = :status";
		return getEntityManager().createQuery(sql, Enrollment.class)
				.setParameter("status", effective).getResultList();
	}

}
