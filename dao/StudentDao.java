package com.jspider.book_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.book_store.connection.BookStoreConnection;
import com.jspider.book_store.dto.Book;
import com.jspider.book_store.dto.BookSeller;
import com.jspider.book_store.dto.Student;

public class StudentDao {

	Connection connection = BookStoreConnection.getBookStoreConnection();

	public List<Student> saveMultipleStudent(List<Student> students) {
		String insertQuery = "insert into student (id,name,email,phone,address,password) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(insertQuery);
			for (Student s1 : students) {
				ps.setInt(1, s1.getId());
				ps.setString(2, s1.getName());
				ps.setString(3, s1.getEmail());
				ps.setLong(4, s1.getPhone());
				ps.setString(5,s1.getAddress());
				ps.setString(6,s1.getPassword());
				ps.addBatch();
			}
			ps.executeBatch();
			return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Student> displayByName(String name) {
		String displayQuery = "select * from student where name=?";

		try {
			PreparedStatement ps = connection.prepareStatement(displayQuery);
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			List<Student> l1 = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name1 = rs.getString("name");
				String email = rs.getString("email");
				long phone=rs.getLong("phone");
				String address=rs.getString("address");
				String password=rs.getString("password");
				Student s1 = new Student(id, name1,email,phone,address,password);

				l1.add(s1);
			}
			return l1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Student> displayById(int id) {
	    String query = "SELECT * FROM student WHERE id = ?";
	    try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        List<Student> s1 = new ArrayList<>();
	        while (rs.next()) {
	            int id1= rs.getInt("id");
	            String name = rs.getString("name");
	            String email = rs.getString("email");
	            long phone = rs.getLong("phone");
	            String address = rs.getString("address");
	            String password = rs.getString("password");
	            Student student = new Student(id1, name, email, phone, address, password);
	            s1.add(student);
	        }
	        return s1;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
