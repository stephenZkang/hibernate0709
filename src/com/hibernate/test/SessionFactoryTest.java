package com.hibernate.test;

import org.hibernate.Session;
import org.junit.Test;

import com.hibernate.utils.HibernateSessionFactory;

/**
 * @author QIAOK
 * @see 用于测试获取session工厂
 * @since 2013/07/09
 */
public class SessionFactoryTest {
	
	@Test
	public void test() {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
	}
}
