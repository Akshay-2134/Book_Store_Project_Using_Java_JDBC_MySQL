package com.jspider.book_store.controller;

import java.util.List;
import java.util.Scanner;

import com.jspider.book_store.dao.BookSellerDao;
import com.jspider.book_store.dao.StudentDao;
import com.jspider.book_store.dto.BookSeller;
import com.jspider.book_store.dto.Student;

public class LoginController {

	public static void getLogin() {
		Student s = new Student();
		BookSeller b = new BookSeller();
		StudentDao dao=new StudentDao();
		BookSellerDao dao1=new BookSellerDao();
		Scanner sc = new Scanner(System.in);
		

		while (true) {
			System.out.println("1.Student\n2.BookSeller\n3.Back");
			System.out.println("Enter your Choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your id");
				int id = sc.nextInt();
				System.out.println("Enter your password");
				String password = sc.next();
				
				List<Student> students=dao.displayById(id);
				
				
				
				if (password.length() <= 10) {
					 Student student = students.get(0); 
				     String actualPassword = student.getPassword();
					if (password.equals(actualPassword)) {
						System.out.println("Login Successfull");
						StudentController.getStudent();
					} else {
						System.out.println("Your Password is Wrong");
					}
				} else {
					System.out.println("Password is too Long");
					System.out.println("You have to enter a password less than 10 characters");
				}

				break;
			case 2:
				System.out.println("Enter your id");
				int id1 = sc.nextInt();
				System.out.println("Enter your password");
				String password1 = sc.next();
				
				List<BookSeller> booksellers=dao1.displayById(id1);
				
				if (password1.length() <= 10) {
					 BookSeller b1 = booksellers.get(0); 
				     String actualPassword = b1.getPassword();
					if (password1.equals(actualPassword)) {
						System.out.println("Login Successfull");
						BookSellerController.getBookSeller();
					} else {
						System.out.println("Your Password is Wrong");
					}
				} else {
					System.out.println("Password is not greater than 10");
					System.out.println("You have to enter password upto 10");
				}
				break;
			case 3:
				return;

			}
		}
	}
}
