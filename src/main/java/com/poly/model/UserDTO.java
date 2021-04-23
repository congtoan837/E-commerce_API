package com.poly.model;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private int Id;
	private String Username;
	private String Name;
	private String Phone;
	private String Address;

	public UserDTO() {
	}

	public UserDTO(int id, String username, String name, String phone, String address) {
		Id = id;
		Username = username;
		Name = name;
		Phone = phone;
		Address = address;
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
}

