package org.kooobao.dcms.core.dao;

import java.util.ArrayList;
import java.util.List;

import org.kooobao.dcms.core.entity.Child;

public class MemoryChildDao extends MemoryDao<Child> implements ChildDao {

	public List<Child> findByLastName(String lastName) {
		List<Child> values = new ArrayList<Child>();
		for (Child c : cache.values()) {
			if (c.getLastName().equals(lastName)) {
				values.add(c);
			}
		}
		return values;
	}

}
