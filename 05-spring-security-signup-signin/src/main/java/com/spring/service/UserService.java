package com.spring.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.entity.User;
import com.spring.model.UserModel;

public interface UserService extends UserDetailsService{

	User findByUserName(String username);

	void save(UserModel userModel);

}
