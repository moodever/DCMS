package org.kooobao.dcms.core.dao.jpa;

import java.util.List;

import org.kooobao.common.dao.JpaDao;
import org.kooobao.dcms.core.dao.ChildDao;
import org.kooobao.dcms.core.entity.Child;

public class JpaChildDao extends JpaDao<Child> implements ChildDao {

	@Override
	public List<Child> findByLastName(String lastName) {
		String sql = "select c from Child c where c.lastName = :lastName";
		return getEntityManager().createQuery(sql, Child.class)
				.setParameter("lastName", lastName).getResultList();
	}
}
