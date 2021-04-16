package com.poly.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Orders implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "CustomerId")
	private int CustomerId;
	@Column(name = "Promotion")
	private String Promotion;
	@Column(name = "Status")
	private String Status;
	@Column(name = "PaymentId")
	private int PaymentId;
	@Column(name = "Address")
	private String Address;

	public Orders() {
	}

	public Orders(Integer id, int customerId, String promotion, String status, int paymentId, String address) {
		Id = id;
		CustomerId = customerId;
		Promotion = promotion;
		Status = status;
		PaymentId = paymentId;
		Address = address;
	}

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
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
}
