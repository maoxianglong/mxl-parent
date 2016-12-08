package com.mxl.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mxl.connection.ConnectionFactory;
import com.mxl.dao.UserDao;
import com.mxl.entity.User;

public class UserDaoImp implements UserDao{

	public boolean checkUser(User u) {
		String sql = "select * from t_user where username = \"" + u.getUserName() + "\"and password = \"" + u.getPassword() + "\"";
		Connection connection;
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.first()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
