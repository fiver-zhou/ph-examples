package com.ph.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ph.dao.UserDao;
import com.ph.model.User;
import com.ph.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> list() {
		return userDao.list(); 
	}
}