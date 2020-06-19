package com.hcl.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User addUser(User user) {
		
		
		sessionFactory.openSession().save(user);
		return user;
	}

	public User getUserById(int id) {
		
		System.out.println("dao");
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
		
	}

	public User updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return user;
	}

	public User deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return user;
	}

	

}
