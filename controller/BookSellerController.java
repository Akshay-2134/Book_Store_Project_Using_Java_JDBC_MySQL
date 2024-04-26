package com.jspider.book_store.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.jspider.book_store.dao.BookDao;
import com.jspider.book_store.dao.OrderDao;
import com.jspider.book_store.dao.StudentDao;
import com.jspider.book_store.dto.Book;
import com.jspider.book_store.dto.Order;
import com.jspider.book_store.dto.Student;

public class BookSellerController {

	public static void getBookSeller() {
		Scanner sc = new Scanner(System.in);
		BookDao dao = new BookDao();
		OrderDao dao1 = new OrderDao();
		while (true) {
			System.out.println(
					"1.Add Book Details\n2.Delete Book Details\n3.Update Book Details\n4.Check Order\n5.Check Students By Phone\n6.Back");
			System.out.println("Enter your chocie");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:

				System.out.println("Add Book Details ");
				System.out.println("Enter Book id");
				int id1 = sc.nextInt();
				System.out.println("Enter Book name");
				String name1 = sc.next();
				System.out.println("Enter Book Author");
				String author1 = sc.next();
				System.out.println("Enter Book Price");
				double price1 = sc.nextDouble();
				Book b1 = new Book(id1, name1, author1, price1);

				System.out.println("Add Another Book Details  ");
				System.out.println("Enter Book id");
				int id2 = sc.nextInt();
				System.out.println("Enter Book name");
				String name2 = sc.next();
				System.out.println("Enter Book Author");
				String author2 = sc.next();
				System.out.println("Enter Book Price");
				double price2 = sc.nextDouble();
				Book b2 = new Book(id2, name2, author2, price2);

				System.out.println("Add Another Book Details ");
				System.out.println("Enter Book id");
				int id3 = sc.nextInt();
				System.out.println("Enter Book name");
				String name3 = sc.next();
				System.out.println("Enter Book Author");
				String author3 = sc.next();
				System.out.println("Enter Book Price");
				double price3 = sc.nextDouble();
				Book b3 = new Book(id3, name3, author3, price3);

				List<Book> books = new ArrayList<Book>(Arrays.asList(b1, b2, b3));
				List<Book> l1 = dao.saveMultipleBook(books);
				if (l1 != null)
					System.out.println("Data Inserted");
				else
					System.out.println("Data not inserted");
				break;
			case 2:
				System.out.println("Enter Book id you want to delete");
				int id = sc.nextInt();
				int s = dao.deleteBook(id);
				if (s != 0)
					System.out.println("Data Deleted");
				else
					System.out.println("Given id is wrong");
				break;
			case 3:
				while (true) {
					System.out.println("1.Update Name\n2.Update Price\n3.Back");
					System.out.println("Enter your Option");
					int choice1 = sc.nextInt();
					switch (choice1) {
					case 1:
						System.out.println("Enter the id of book ");
						int n = sc.nextInt();
						System.out.println("Changed Name of Book");
						String bookname = sc.next();
						int a = dao.updateBookByName(n, bookname);
						if (a != 0)
							System.out.println("Data Updated");
						else
							System.out.println("Given id is wrong");
						break;
					case 2:
						System.out.println("Enter the id of book ");
						int j = sc.nextInt();
						System.out.println("Changed Price of Book");
						double price = sc.nextDouble();
						int w = dao.updateBookByPrice(j, price);
						if (w != 0)
							System.out.println("Data Updated");
						else
							System.out.println("Given id is wrong");
						break;

					case 3:
						return;
					default:
						System.out.println("Invalid choice");
						break;
					}

				}

			case 4:
				System.out.println("Enter the Name of Book");
				String name4=sc.next();

				List<Order> l2 = dao1.checkOrderBookById(null,name4);
				if (l2 == null || l2.isEmpty()) {
					System.out.println("Given Book is not Ordered yet");
				} else {
					for (Order orders : l2) {
						System.out.println(orders);
					}
				}
				break;
			case 5:
				System.out.println("Enter the Phone Number Of Student");
				long studentPhone = sc.nextLong();

				List<Student> l3 = dao1.checkStudentByPhone(null, studentPhone);
				if (l3 == null || l3.isEmpty()) {
					System.out.println("Given Phone Number doesn't exist");
				} else {
					for (Student student : l3) {
						System.out.println(student);
					}
				}
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
}
