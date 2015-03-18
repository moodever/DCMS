package org.kooobao.dcms.core.dao.jpa;

import javax.persistence.NoResultException;

import org.kooobao.common.dao.JpaDao;
import org.kooobao.dcms.core.dao.ClassroomDao;
import org.kooobao.dcms.core.entity.Classroom;

public class JpaClassroomDao extends JpaDao<Classroom> implements ClassroomDao {

	@Override
	public Classroom findByNameTerm(String name, String term) {
		String sql = "select c from Classroom c where c.name = :name and c.term = :term";

		try {
			return getEntityManager().createQuery(sql, Classroom.class)
					.setParameter("name", name).setParameter("term", term)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
