package org.kooobao.dcms.core.dao;

import java.util.List;

import org.kooobao.common.dao.Dao;
import org.kooobao.dcms.core.entity.Child;

public interface ChildDao extends Dao<Child> {

	public List<Child> findByLastName(String lastName);
}
