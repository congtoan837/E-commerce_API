package com.poly.dto;

import com.poly.model.Payment;
import com.poly.model.Promotion;
import com.poly.model.Users;

import java.io.Serializable;

public class OrderDTO implements Serializable {
	private int Id;
	private Users users;
	private String Address;
	private Promotion promotion;
	private Payment payment;
	private String Status;
	private long Total;
	private String CreateTime;

	public OrderDTO() {
	}

	public OrderDTO(int id, Users users, String address, Promotion promotion, Payment payment, String status, long total) {
		Id = id;
		this.users = users;
		Address = address;
		this.promotion = promotion;
		this.payment = payment;
		Status = status;
		Total = total;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public long getTotal() {
		return Total;
	}

	public void setTotal(long total) {
		Total = total;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
}

