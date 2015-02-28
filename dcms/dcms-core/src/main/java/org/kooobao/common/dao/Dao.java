package org.kooobao.common.dao;

public interface Dao<T extends Entity> {

	public T findById(int id);
	
	public void delete(T target);
	
	public T save(T obj);
}
