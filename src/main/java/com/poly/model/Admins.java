package com.poly.model;

import java.io.Serializable;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admins implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "Name", length = 50)
    private String Name;
	@Column(name = "Password", length = 50)
    private String Password;
	@Column(name = "Role", length = 50)
	private String Role;
	
	public Admins() {
		super();
	}

	public Admins(Integer id, String name, String password, String role) {
		super();
		Id = id;
		Name = name;
		Password = password;
		Role = role;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
}
