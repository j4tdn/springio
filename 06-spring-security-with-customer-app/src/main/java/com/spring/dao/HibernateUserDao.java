package com.spring.dao;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public class HibernateUserDao implements UserDao {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private SessionFactory sessionFactory;

	private static final String Q_FIND_BY_USER_NAME = "SELECT user FROM User user WHERE user.username = :username";

	@Override
	public User findByUserName(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		try {
			user = session.createQuery(Q_FIND_BY_USER_NAME, User.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (Exception e) {
			logger.warning("Username already exist");
		}

		return user;
	}

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

}
