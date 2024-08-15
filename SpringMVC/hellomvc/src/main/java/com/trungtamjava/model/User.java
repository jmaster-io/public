package com.trungtamjava.model;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class User {
	private int id;

//	@Length(min = 6, max = 10, message = "Username length is from 6 to 10 chars")
	private String username;

//	@Length(min = 6, max = 10, message = "Password length is from 6 to 10 chars")
	private String password;

	private String role; // Admin, Member, Teacher

//	@NotEmpty(message = "Name khong duoc trong")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}