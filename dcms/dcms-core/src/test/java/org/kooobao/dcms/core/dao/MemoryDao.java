package org.kooobao.dcms.core.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kooobao.common.dao.Dao;
import org.kooobao.common.dao.Entity;

public class MemoryDao<T extends Entity> implements Dao<T> {

	protected Map<Integer, T> cache;

	public MemoryDao() {
		cache = new HashMap<Integer, T>();
	}

	public T findById(int id) {
		return cache.get(id);
	}

	public void delete(T target) {
		if (target.getId() != -1)
			cache.remove(target.getId());
	}

	public T save(T obj) {
		cache.put(obj.getId(), obj);
		return obj;
	}

	@Override
	public org.kooobao.common.dao.Dao.Cursor<T> all() {
		return null;
	}

	@Override
	public List<T> allatonce() {
		List<T> list = new ArrayList<T>();
		list.addAll(cache.values());
		return list;
	}
}
