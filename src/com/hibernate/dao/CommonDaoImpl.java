package com.hibernate.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.utils.HibernateSessionFactory;

@SuppressWarnings({"unchecked","rawtypes"})
public class CommonDaoImpl<T> implements CommonDao<T> {
	
	private  Class clazz;
	private final Session session;
	public CommonDaoImpl() {
		ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class) parameterizedType.getActualTypeArguments()[0];
		session = HibernateSessionFactory.getSession();
		session.beginTransaction();
	}

	public void delete(T t) {
		try {
			session.delete(t);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public T getById(Serializable id) {
		return (T) session.get(clazz, id);
	}

	public List<T> list() {
		return session.createQuery("from "+clazz.getName()).list();
	}

	public void save(T t) {
		try {
			session.save(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public void update(T t) {
		try {
			session.update(t);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}finally {
			HibernateSessionFactory.closeSession();
		}
	}

	
	public List<T> search(String where, String order, Object[] params) {
		String hql = "from " + clazz.getName()+ " as vo";
		if(where !=null&& where.length()>0) {
			where = " where "+ where;
			hql = hql+where;
		}
		
		if (order!=null && order.length()>0) {
			order = " order by " + order;
			hql = hql + order;
		}
		Query query = session.createQuery(hql);
		
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List list = query.list();
		return list;
	}

	public Class getClazz() {
		return clazz;
	}
	
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
}
