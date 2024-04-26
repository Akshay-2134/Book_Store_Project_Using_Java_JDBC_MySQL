package com.jspider.book_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.book_store.connection.BookStoreConnection;
import com.jspider.book_store.dto.Book;

public class BookDao {

	Connection connection = BookStoreConnection.getBookStoreConnection();

	public List<Book> saveMultipleBook(List<Book> books) {
		String insertQuery = "insert into book (id,name,author,price) values(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(insertQuery);
			for (Book b1 : books) {
				ps.setInt(1, b1.getId());
				ps.setString(2, b1.getName());
				ps.setString(3, b1.getAuthor());
				ps.setDouble(4, b1.getPrice());
				ps.addBatch();
			}
			ps.executeBatch();
			return books;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int deleteBook(int id) {
		String deleteQuery = "delete from book where id=?";
		int a = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(deleteQuery);
			ps.setInt(1, id);
			a = ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return a;
		}
	}

	public int updateBookByName(int id, String name) {
		String deleteQuery = "update book set name=? where id=?";
		int a = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(deleteQuery);
			ps.setString(1, name);
			ps.setInt(2, id);
			a = ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return a;
		}
	}

	public int updateBookByPrice(int id, double price) {
		String deleteQuery = "update book set price=? where id=?";
		int a = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(deleteQuery);
			ps.setDouble(1, price);
			ps.setInt(2, id);
			a = ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return a;
		}
	}

	public List<Book> displayAllBooks() {
		String displayQuery = "select * from book";

		try {
			PreparedStatement ps = connection.prepareStatement(displayQuery);
			ResultSet rs = ps.executeQuery();
			List<Book> l1 = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				Book book1 = new Book(id, name, author, price);

				l1.add(book1);
			}
			return l1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
