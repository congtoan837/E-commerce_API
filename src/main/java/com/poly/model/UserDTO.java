package com.poly.model;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
	private int Id;
	private String Username;
	private String Name;
	private String Phone;
	private String Address;
	private List Role;

	public UserDTO() {
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public List getRole() {
		return Role;
	}

	public void setRole(List role) {
		Role = role;
	}
}
