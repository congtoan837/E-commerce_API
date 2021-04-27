package com.poly.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "Name")
    private String Name;
	@Column(name = "Email")
    private String Email;
	@Column(name = "Phone")
    private String Phone;
	@Column(name = "Address")
    private String Address;
	@Column(name = "Password")
    private String Password;
	@Column(name = "Image")
    private String Image;
	@Column(name = "Status")
    private String Status;
	@Column(name = "Username")
	private String Username;
	@Column(name = "Role")
	private String Role;

	@Column(name = "CreateTime")
	@Temporal(TemporalType.DATE)
	private Date createTime;
	
	
	public Users() {

	}

	public Users(Integer id, String name, String email, String phone, String address, String password, String image, String status, String username, String role) {
		Id = id;
		Name = name;
		Email = email;
		Phone = phone;
		Address = address;
		Password = password;
		Image = image;
		Status = status;
		Username = username;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
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

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
