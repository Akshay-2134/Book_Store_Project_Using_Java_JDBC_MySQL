package com.jspider.book_store.controller;

import java.util.Scanner;

public class MainController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.Register\n2.Login\n3.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				RegisterController.getRegister();
				break;
			case 2:
				LoginController.getLogin();
				break;
			case 3:
				System.out.println("Your Application is Terminated");
				System.exit(1);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}

	}
}
