package org.kooobao.dcms.core.dao.jpa;

import java.util.List;

import org.kooobao.common.dao.JpaDao;
import org.kooobao.dcms.core.dao.EnrollmentDao;
import org.kooobao.dcms.core.entity.Enrollment;
import org.kooobao.dcms.core.entity.Enrollment.Status;

public class JpaEnrollmentDao extends JpaDao<Enrollment> implements
		EnrollmentDao {

	@Override
	public Enrollment findByStatus(Status status, int childId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enrollment> findByStatus(Status effective) {
		// TODO Auto-generated method stub
		return null;
	}

}
