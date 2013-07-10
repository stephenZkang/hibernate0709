package com.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.hibernate.utils.HibernateSessionFactory;

/**
 * @author QIAOK
 * 
 * @since 2013/07/09
 */
public abstract class BaseDao<T> {
	private static Session session;
	static {
		session = HibernateSessionFactory.getSession();
	}
	
	public void save(T t) {
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}
	
	public void update(T t) {
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();
	}
	
	public void delete(T t) {
		session.beginTransaction();
		session.delete(t);
		session.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(){
		return session.createQuery("from ").list();
	}
	
	@SuppressWarnings("unchecked")
	public T getById(Serializable id) {
		Object object = session.get("", id);
		return (T)object;
	}
}
