package com.hibernate.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author QIAOK
 * @see 利用泛型来构建底层Dao
 * @since 2013/07/10
 */
public interface CommonDao<T> {
	public void save(T t);
	public void delete(T t);
	public void update(T t);
	public T getById(Serializable id);
	public List<T> list();
	public List<T> search(String where,String order,Object[] params);
}
