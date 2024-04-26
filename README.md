
# Book Store Project By Using Core Java,OOPS Concepts,JDBC and MySQL


This Book Store Management System is a Java-based application designed to streamline book inventory, sales, and student interactions. It offers features such as user registration, authentication, book management (addition, deletion, and updating), order processing, and database connectivity through JDBC. With a clear separation of concerns using controllers, DAOs, and DTOs, this system provides a scalable and organized solution for book store management tasks.


## Features

- Registration: Allows students and book sellers to register.
- Login: Provides authentication for registered users(Student and BookSeller).
- Book Management: Management of student and book seller      details including ID, name, email, phone, address, and password.

  - BookSeller Features
    - Add Book Details.
    - Delete Book Details.
    - Update book details.
       - By Color.
       - By Name.
    - Checking orders for a particular book .
    - Check Student details by phone number. 
    - Back to Main Menu

  -  Student Features

     -  Display all  available books in the store.
     -  Display all details of student By name.
     - Ordering books by ID, with automatic generation of order IDs.
     - Back to Main Menu
   
















## Components

  - Controllers: Handle user input and interact with DAOs.
  - DAOs (Data Access Objects): Perform database operations.
  - DTOs (Data Transfer Objects): Represent data entities like books, students, etc.
  - Connection: Establishes a connection to the database.

## DataBase Connectivity


   - Utilizes JDBC for database operations.
   - Database connectivity using JDBC for seamless integration with a MySQL database.
   - Interaction with the database to ensure seamless data retrieval and storage tailored to student activities.
## Tech Stack



**Backend:** Java

**Database:** MySQL

**Connection Handling:** JDBC

**Development Environment:** Eclipse IDE

**Version Control:**  Git

**Code Hosting:** GitHub







## Usage

  - Clone the repository.
  - Set up a MySQL database and configure the  connection details in BookStoreConnection.java.
   - Run the MainController.java file to start the application.
## Contributing

  - Fork the repository.
  - Make your changes.
  - Create a pull request detailing the changes you've made.
