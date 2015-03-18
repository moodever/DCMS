package org.kooobao.dcms.core.dao;

import org.kooobao.common.dao.Dao;
import org.kooobao.dcms.core.entity.Classroom;

public interface ClassroomDao extends Dao<Classroom> {

	public Classroom findByNameTerm(String name, String term);
}
