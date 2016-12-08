package com.mxl.service.imp;

import com.mxl.dao.UserDao;
import com.mxl.dao.imp.UserDaoImp;
import com.mxl.entity.User;
import com.mxl.service.UserService;

public class UserServiceimp implements UserService{

	private UserDao userDao = new UserDaoImp();
	
	public boolean checkUser(User user) {
		return userDao.checkUser(user);
	}
}
