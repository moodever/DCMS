package org.kooobao.dcms.core.dao;

import org.kooobao.dcms.core.entity.Classroom;

public class MemoryClassroomDao extends MemoryDao<Classroom> implements
		ClassroomDao {

	@Override
	public Classroom findByNameTerm(String name, String term) {
		for (Classroom c : cache.values()) {
			if (c.getName().equals(name) && c.getTerm().equals(term))
				return c;
		}
		return null;
	}

}
