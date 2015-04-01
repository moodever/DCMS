package org.kooobao.dcms.core.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public List<Classroom> findByTerm(String term) {
		
		List<Classroom> cr = new ArrayList<Classroom>();
		for (Classroom c : cache.values()) {
			if (c.getTerm().equals(term))
				cr.add(c);
		}
		return cr;
	}

}
