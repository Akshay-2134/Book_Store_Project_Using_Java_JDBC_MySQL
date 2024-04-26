package com.jspider.book_store.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.jspider.book_store.dao.BookDao;
import com.jspider.book_store.dao.OrderDao;
import com.jspider.book_store.dao.StudentDao;
import com.jspider.book_store.dto.Book;
import com.jspider.book_store.dto.Order;
import com.jspider.book_store.dto.Student;

public class StudentController {

	public static void getStudent() {
		BookDao dao = new BookDao();
		StudentDao dao1 = new StudentDao();
		OrderDao dao2 = new OrderDao();
		Student r=new Student();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.Display All Books\n2.Display By Name\n3.Order Book By Id\n4.Back");
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				List<Book> l1 = dao.displayAllBooks();
				for (Book b1 : l1) {
					if (b1 == null) {
						break;
					}
					System.out.println(b1);

				}
				break;
			case 2:
				System.out.println("Enter the Name Of Student");
				String name = sc.next();
				List<Student> l2 = dao1.displayByName(name);
				for (Student b2 : l2) {
					if (b2 == null) {
						break;
					}
					System.out.println(b2);
				}
				break;
			case 3:
				Random rand = new Random();
				System.out.println("id is automatically created");
				int id = rand.nextInt(90) + 10;
				System.out.println("Enter Student Name");
				String name5=sc.next() ;
				System.out.println("Enter the Book name");
				String bookName = sc.next();
				long studentPhone = 1234567890;

				Order o1 = new Order(id, studentPhone, bookName);
				List<Order> orders = new ArrayList<Order>(Arrays.asList(o1));
				List<Order> l3 = dao2.orderBookById(orders,name5);
				if (l3 != null)
					System.out.println("Data Inserted");
				else
					System.out.println("Data not inserted");
				break;

			case 4:
				return;
			default:
				System.out.println("Invalid Choice");
			}
		}

	}
}
