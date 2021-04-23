package com.poly.model;

import java.io.Serializable;

public class OrderDTO implements Serializable {
	private int Id;
	private String Users;
	private String Phone;
	private String Address;
	private int Promotion;
	private String Coupon;
	private String Payment;
	private String Status;
	private long Total;
	private String CreateTime;

	public OrderDTO() {
	}

	public OrderDTO(int id, String users, String phone, String address, int promotion, String coupon,String payment, String status, long total) {
		Id = id;
		Users = users;
		Phone = phone;
		Address = address;
		Promotion = promotion;
		Coupon = coupon;
		Payment = payment;
		Status = status;
		Total = total;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsers() {
		return Users;
	}

	public void setUsers(String users) {
		Users = users;
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

	public int getPromotion() {
		return Promotion;
	}

	public void setPromotion(int promotion) {
		Promotion = promotion;
	}

	public String getCoupon() {
		return Coupon;
	}

	public void setCoupon(String coupon) {
		Coupon = coupon;
	}

	public String getPayment() {
		return Payment;
	}

	public void setPayment(String payment) {
		Payment = payment;
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

