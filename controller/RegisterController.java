package com.jspider.book_store.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.jspider.book_store.dao.BookSellerDao;
import com.jspider.book_store.dao.StudentDao;
import com.jspider.book_store.dto.BookSeller;
import com.jspider.book_store.dto.Student;

public class RegisterController {

	public static void getRegister() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (true) {
			System.out.println("1.Student\n2.BookSeller\n3.Back");
			System.out.println("Enter your Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				StudentDao dao = new StudentDao();
				System.out.println("how mant times you want to add data");
				int n = sc.nextInt();

				while (n > 0) {
					System.out.println("Enter Student Details ");
					System.out.println("Enter id,name,email,Phone,address,Password");
					System.out.println("Enter student id");
					int id1 = sc.nextInt();
					System.out.println("Enter Student name");
					String name1 = sc.next();
					System.out.println("Enter Student email");
					String email1 = sc.next();
					System.out.println("Enter Student Phone");
					long phone1 = sc.nextLong();
					System.out.println("Enter Student Address");
					String address1 = sc.next();
					System.out.println("Enter Student password");
					String password1 = sc.next();
					Student s1 = new Student(id1, name1, email1, phone1, address1, password1);
					List<Student> students = new ArrayList<Student>(Arrays.asList(s1));
					List<Student> l1 = dao.saveMultipleStudent(students);
					if (l1 != null)
						System.out.println("Data Inserted");
					else
						System.out.println("Data not inserted");
					n--;
					System.out.println("+++++++++++++++++++++++++++++++++");

				}

			}
				break;
			case 2: {
				BookSellerDao dao = new BookSellerDao();
				System.out.println("Enter BookSeller Details");
				System.out.println("Enter BookSeller id");
				int id1 = sc.nextInt();
				System.out.println("Enter BookSeller name");
				String name1 = sc.next();
				System.out.println("Enter BookSeller email");
				String email1 = sc.next();
				System.out.println("Enter BookSeller Phone");
				long phone1 = sc.nextLong();
				System.out.println("Enter BookSeller address");
				String address1 = sc.next();
				System.out.println("Enter BookSeller Password");
				String password1 = sc.next();

				BookSeller s1 = new BookSeller(id1, name1, email1, phone1, address1, password1);

				System.out.println("Enter Another BookSeller Details");
				System.out.println("Enter BookSeller id");
				int id2 = sc.nextInt();
				System.out.println("Enter BookSeller name");
				String name2 = sc.next();
				System.out.println("Enter BookSeller email");
				String email2 = sc.next();
				System.out.println("Enter BookSeller Phone");
				long phone2 = sc.nextLong();
				System.out.println("Enter BookSeller address");
				String address2 = sc.next();
				System.out.println("Enter BookSeller Password");
				String password2 = sc.next();

				BookSeller s2 = new BookSeller(id2, name2, email2, phone2, address2, password2);

				System.out.println("Enter Another BookSeller Details");
				System.out.println("Enter BookSeller id");
				int id3 = sc.nextInt();
				System.out.println("Enter BookSeller name");
				String name3 = sc.next();
				System.out.println("Enter BookSeller email");
				String email3 = sc.next();
				System.out.println("Enter BookSeller Phone");
				long phone3 = sc.nextLong();
				System.out.println("Enter BookSeller address");
				String address3 = sc.next();
				System.out.println("Enter BookSeller Password");
				String password3 = sc.next();

				BookSeller s3 = new BookSeller(id3, name3, email3, phone3, address3, password3);

				List<BookSeller> booksellers = new ArrayList<BookSeller>(Arrays.asList(s1, s2, s3));
				List<BookSeller> b1 = dao.saveMultipleBookSeller(booksellers);
				if (b1 != null)
					System.out.println("Data Inserted");
				else
					System.out.println("Data not Inserted");

			}
				break;
			case 3:
				return;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
}
