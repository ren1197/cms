package com.gx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gx.dao.UserDao;
import com.gx.po.UserPo;
import com.gx.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserPo selectLogin(UserPo user) {
		return userDao.selectLogin(user);
	}

}
