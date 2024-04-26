package com.jspider.book_store.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspider.book_store.connection.BookStoreConnection;
import com.jspider.book_store.dto.Book;
import com.jspider.book_store.dto.BookSeller;
import com.jspider.book_store.dto.Student;

public class BookSellerDao {
     
	Connection connection=BookStoreConnection.getBookStoreConnection();
	
	public List<BookSeller> saveMultipleBookSeller(List<BookSeller> booksellers)
	{
		String insertQuery="insert into bookseller (id,name,email,phone,address,password) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(insertQuery);
			for (BookSeller b1 : booksellers) {
				ps.setInt(1, b1.getId());
				ps.setString(2,b1.getName());
				ps.setString(3,b1.getEmail());
				ps.setLong(4, b1.getPhone());
				ps.setString(5,b1.getAddress());
				ps.setString(6,b1.getPassword());
				ps.addBatch();
			}
			ps.executeBatch();
			return booksellers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<BookSeller> displayById(int id) {
	    String query = "SELECT * FROM bookseller WHERE id = ?";
	    try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        List<BookSeller> s1 = new ArrayList<>();
	        while (rs.next()) {
	            int id1= rs.getInt("id");
	            String name = rs.getString("name");
	            String email = rs.getString("email");
	            long phone = rs.getLong("phone");
	            String address = rs.getString("address");
	            String password = rs.getString("password");
	            BookSeller booksellers = new BookSeller(id1, name, email, phone, address, password);
	            s1.add(booksellers);
	        }
	        return s1;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	
	
}
