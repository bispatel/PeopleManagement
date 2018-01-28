package com.as.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.as.model.User;

@Repository
@Transactional
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory1;

	private Session getSession() {
		return sessionFactory1.getCurrentSession();
	}

	public String saveUser(User user) {
		Integer isSuccess = (Integer) getSession().save(user);
		if (isSuccess >= 1) {
			return "Success";
		} else {
			return "Error while Saving user";
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		//return getSession().createQuery("from User").list();
		
		   Criteria c = getSession().createCriteria(User.class)
	                .createCriteria("village", Criteria.LEFT_JOIN);
	            return c.list();
		
		
	}

	public User getUser(String userId) {
		User query = (User) getSession().get(User.class, userId);
		return query;
	}

	public void updateUser(User user) {
		getSession().saveOrUpdate(user);
	}

	public void deleteUser(User user) {
		getSession().delete(user);
	}

}
