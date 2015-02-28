package org.kooobao.dcms.core.dao.jpa;

import java.util.List;

import org.kooobao.common.dao.JpaDao;
import org.kooobao.dcms.core.dao.ChildDao;
import org.kooobao.dcms.core.entity.Child;

public class JpaChildDao extends JpaDao<Child> implements ChildDao {

	@Override
	public List<Child> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
