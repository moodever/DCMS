package org.kooobao.dcms.core.dao.jpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.kooobao.common.dao.JpaDao;
import org.kooobao.dcms.core.dao.EnrollmentDao;
import org.kooobao.dcms.core.entity.Child;
import org.kooobao.dcms.core.entity.Classroom;
import org.kooobao.dcms.core.entity.Enrollment;
import org.kooobao.dcms.core.entity.Enrollment.Status;

public class JpaEnrollmentDao extends JpaDao<Enrollment> implements
		EnrollmentDao {

	@Override
	public Enrollment findByStatusForChild(Status status, Child child) {
		String sql = "select e from Enrollment e where e.status = :status and e.child.id = :childId";
		try {
			return getEntityManager().createQuery(sql, Enrollment.class)
					.setParameter("status", status)
					.setParameter("childId", child.getId()).getSingleResult();
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

	@Override
	public List<Enrollment> findActiveInClassroom(Classroom clsrm) {
		String sql = "select e from Enrollment e where e.classroom = :clsrm and e.status = :status";
		return getEntityManager().createQuery(sql, Enrollment.class)
				.setParameter("clsrm", clsrm)
				.setParameter("status", Enrollment.Status.EFFECTIVE)
				.getResultList();
	}

}
