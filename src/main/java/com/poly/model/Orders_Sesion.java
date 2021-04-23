package com.poly.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Orders_Sesion implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "Customer")
	private String Customer;
	@Column(name = "Phone")
	private String Phone;
	@Column(name = "Promotion")
	private String Promotion;
	@Column(name = "Status")
	private String Status;
	@Column(name = "PaymentId")
	private int PaymentId;
	@Column(name = "Address")
	private String Address;
	@Column(name = "IsDelete")
	private boolean IsDelete;


	public Orders_Sesion() {
	}

	public Orders_Sesion(Integer id, String customer, String phone, String promotion, String status, int paymentId, String address, boolean isDelete) {
		Id = id;
		Customer = customer;
		Phone = phone;
		Promotion = promotion;
		Status = status;
		PaymentId = paymentId;
		Address = address;
		IsDelete = isDelete;
	}

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getCustomer() {
		return Customer;
	}
	public void setCustomer(String customer) {
		Customer = customer;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getPromotion() { return Promotion; }
	public void setPromotion(String promotion) { Promotion = promotion; }
	public String getStatus() { return Status; }
	public void setStatus(String status) { Status = status; }
	public int getPaymentId() { return PaymentId; }
	public void setPaymentId(int paymentId) { PaymentId = paymentId; }

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
