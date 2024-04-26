package com.jspider.book_store.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class BookStoreConnection {
   
	public static Connection getBookStoreConnection()
	{
		try {
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			
			String url="JDBC:MySQL://localhost:3306/jdbc_project";
			String user="root";
			String password="Akshay@123";
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
