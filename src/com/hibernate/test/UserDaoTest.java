package com.hibernate.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hibernate.dao.UserDao;
import com.hibernate.dao.UserDaoImpl;
import com.hibernate.model.Department;
import com.hibernate.model.User;

/**
 * @author QIAOK
 * @see
 * @since 2013/07/10
 */
public class UserDaoTest {
	
	private UserDao<User> userDao ;
	@Before
	public void init() {
		userDao = new UserDaoImpl();
	}
	
	@Test
	public void save() {
		User user = new User();
		user.setName("Laughing Sir");
		user.setEmail("Laughing@foxmail.com");
		userDao.save(user);
		
	}
	
	@Test
	public void update() {
		Department department = new Department();
		department.setId(1);
		User user = new User();
		user.setId(1);
		user.setName("xiaolong");
		user.setDepartment(department);
		userDao.update(user);
	}
	
	@Test
	public void delete() {
		User user = new User();
		user.setId(1);
		userDao.delete(user);
	}
	
	@Test
	public void list() {
		List<User> list = userDao.list();
		if(list!=null && list.size()>0) {
			for (User user : list) {
				System.out.println(user.getName());
				System.out.println(user.getEmail());
				Department department = user.getDepartment();
				System.out.println(department.getName());
			}
		}
	}
	
	@Test
	public void search() {
		List<User> list = userDao.search("vo.id=?", null, new Object[] {2});
		if(list!= null&& list.size()>0) {
			for (User user : list) {
				System.out.println(user.getEmail());
			}
		}
	}
	
	@Test
	public void getById() {
		User user = userDao.getById(2);
		if(user!=null) {
			System.out.println(user.getName());
		}
	}
	
}
