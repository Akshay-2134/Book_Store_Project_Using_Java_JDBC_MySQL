package com.jspider.book_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jspider.book_store.connection.BookStoreConnection;
import com.jspider.book_store.dto.Order;
import com.jspider.book_store.dto.Student;

public class OrderDao {
	Connection connection = BookStoreConnection.getBookStoreConnection();

	public List<Order> orderBookById(List<Order> orders, String studentName) {
		String insertQuery = "INSERT INTO `order` (id, studentphone, bookname) "
				+ "SELECT ?, phone, ? FROM student WHERE name = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(insertQuery);
			for (Order order : orders) {
				ps.setInt(1, order.getId());
				ps.setString(2, order.getBookName());
				ps.setString(3, studentName);
				ps.addBatch();
			}
			ps.executeBatch();
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Order> checkOrderBookById(List<Order> orders1,String name1) {
		String displayQuery = "SELECT * FROM `order` WHERE bookname = (SELECT name FROM book WHERE name = ?)";

		try (PreparedStatement ps = connection.prepareStatement(displayQuery)) {
			ps.setString(1, name1);
			ResultSet rs = ps.executeQuery();
				List<Order> l1 = new ArrayList<>();
				while (rs.next()) {
                   int id1=rs.getInt("id");
                   long studentphone=rs.getLong("studentphone");
                   String bookname=rs.getString("bookname");
                   Order order = new Order(id1,studentphone,bookname);
			       l1.add(order);
				}
				return l1;
			}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Student> checkStudentByPhone(List<Student> students, long studentPhone) {
		String displayQuery = "SELECT * FROM student WHERE phone = (SELECT studentphone FROM `order` WHERE studentphone= ?)";

		try (PreparedStatement ps = connection.prepareStatement(displayQuery)) {
			ps.setLong(1, studentPhone);
			ResultSet rs = ps.executeQuery();
				List<Student> l1 = new ArrayList<>();
				while (rs.next()) {	
                   int id=rs.getInt("id");
                   String name=rs.getString("name");
                   String email=rs.getString("email");
                   long phone1=rs.getLong("phone");
                   String address1=rs.getString("address");
                   String password1=rs.getString("password");
                   Student student1 = new Student(id,name,email,phone1,address1,password1);
			       l1.add(student1);
				}
				return l1;
			}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

