package com.spring.dao;

import com.spring.entity.User;

public interface UserDao {
	User findByUserName(String username);

	void save(User user);
}
