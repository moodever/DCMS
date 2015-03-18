package org.kooobao.dcms.core.dao;

import java.util.ArrayList;
import java.util.List;

import org.kooobao.dcms.core.entity.Child;
import org.kooobao.dcms.core.entity.Enrollment;
import org.kooobao.dcms.core.entity.Enrollment.Status;

public class MemoryEnrollmentDao extends MemoryDao<Enrollment> implements
		EnrollmentDao {

	@Override
	public Enrollment findByStatusForChild(Status status, Child child) {
		for (Enrollment e : super.cache.values()) {
			if (e.getChild().getId() == child.getId()
					&& e.getStatus() == status)
				return e;
		}
		return null;
	}

	@Override
	public List<Enrollment> findByStatus(Status effective) {
		List<Enrollment> result = new ArrayList<Enrollment>();
		for (Enrollment e : super.cache.values()) {
			if (e.getStatus() == effective)
				result.add(e);
		}
		return result;
	}

}
