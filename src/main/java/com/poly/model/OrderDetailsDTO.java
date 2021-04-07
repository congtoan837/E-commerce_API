package com.poly.model;

import java.io.Serializable;
import java.util.List;

public class OrderDetailsDTO implements Serializable {
	private int Id;
	private Product product;
	private int Quantity;
	private int TotalPrice;
	private String Promotion;
	private String Status;
	private int PaymentId;
	private String CreateTime;

	public OrderDetailsDTO() {
	}

	public OrderDetailsDTO(int id, Product product, int quantity, int totalPrice, String promotion, String status, int paymentId, String createTime) {
		Id = id;
		this.product = product;
		Quantity = quantity;
		TotalPrice = totalPrice;
		Promotion = promotion;
		Status = status;
		PaymentId = paymentId;
		CreateTime = createTime;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}

	public String getPromotion() {
		return Promotion;
	}

	public void setPromotion(String promotion) {
		Promotion = promotion;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getPaymentId() {
		return PaymentId;
	}

	public void setPaymentId(int paymentId) {
		PaymentId = paymentId;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
}

