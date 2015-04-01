package org.kooobao.dcms.core.dao;

import java.util.List;

import org.kooobao.common.dao.Dao;
import org.kooobao.dcms.core.entity.Classroom;

public interface ClassroomDao extends Dao<Classroom> {

	public Classroom findByNameTerm(String name, String term);
	
	public List<Classroom> findByTerm(String term);
	
	
}
