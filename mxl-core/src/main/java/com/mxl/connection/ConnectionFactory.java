package com.mxl.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private String url = "jdbc:mysql:///db_mm";
	private String driver = "com.mysql.jdbc.Driver";
	private String user = "root";
	private String password = "123456";
	private Connection connection = null;
	private static ConnectionFactory connectionFactory = null;
	
	public static ConnectionFactory getInstance(){
		synchronized (ConnectionFactory.class) {
			if (connectionFactory == null) {
				connectionFactory = new ConnectionFactory();
			}
			return connectionFactory;
		}
	}
	
	private ConnectionFactory(){}
	
	public Connection getConnection() throws SQLException{
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);  
		} catch (ClassNotFoundException e) {
			System.err.println("获取链接异常");
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void main(String[] args) throws SQLException {
		boolean b = ConnectionFactory.getInstance().getConnection().getAutoCommit();
		System.out.println(b);
	}
}
