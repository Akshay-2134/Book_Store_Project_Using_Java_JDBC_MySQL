package com.jspider.book_store.dto;

public class Student {
	private int id;
	private String name;
	private String email;
	private long phone;
	private String address;
	private String password;

	public Student() {
		super();
	}

	public Student(int id, String name, String email, long phone, String address, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "ID is: " + id + " Name is: " + name + " Email is: " + email + " Phone is: " + phone +" Address is: "+address+ " Password is: "
				+ password;
	}

}
