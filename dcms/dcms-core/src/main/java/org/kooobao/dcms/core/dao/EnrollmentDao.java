package org.kooobao.dcms.core.dao;

import java.util.List;

import org.kooobao.common.dao.Dao;
import org.kooobao.dcms.core.entity.Child;
import org.kooobao.dcms.core.entity.Enrollment;
import org.kooobao.dcms.core.entity.Enrollment.Status;

public interface EnrollmentDao extends Dao<Enrollment> {

	public Enrollment findByStatusForChild(Status status, Child child);

	public List<Enrollment> findByStatus(Status effective);

}
