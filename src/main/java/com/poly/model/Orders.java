package com.poly.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Orders implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@ManyToOne
	@JoinColumn(name = "CustomerId")
	private Users users;

	@ManyToOne
	@JoinColumn(name = "Promotion")
	private Promotion promotion;

	@Column(name = "Status")
	private String Status;

	@ManyToOne
	@JoinColumn(name = "PaymentId")
	private Payment payment;

	@Column(name = "Address")
	private String Address;
	@Column(name = "IsDelete")
	private boolean IsDelete;


	public Orders() {
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public boolean isDelete() {
		return IsDelete;
	}

	public void setDelete(boolean delete) {
		IsDelete = delete;
	}

}
