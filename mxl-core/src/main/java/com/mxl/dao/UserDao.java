package com.mxl.dao;

import java.sql.SQLException;

import com.mxl.entity.User;

public interface UserDao {

	boolean checkUser(User u);
	
}
