package org.kooobao.dcms.core.dao;

import java.util.List;

import org.kooobao.common.dao.Dao;
import org.kooobao.dcms.core.entity.Enrollment;
import org.kooobao.dcms.core.entity.Enrollment.Status;

public interface EnrollmentDao extends Dao<Enrollment> {

	public Enrollment findByStatus(Status status, int childId);

	public List<Enrollment> findByStatus(Status effective);

}
