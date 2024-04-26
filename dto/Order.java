package com.jspider.book_store.dto;

public class Order {
	private int id;
	private long studentPhone;
	private String bookName;

	public Order() {
		super();
	}

	public Order(int id, long studentPhone, String bookName) {
		super();
		this.id = id;
		this.studentPhone = studentPhone;
		this.bookName = bookName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(long studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
   public String toString() {
	   return "Id is: "+id+" Student Phone Number is: "+studentPhone+" Book Name is: "+bookName;
   }
}
