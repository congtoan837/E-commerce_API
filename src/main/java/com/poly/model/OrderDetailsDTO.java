package com.poly.model;

import java.io.Serializable;
import java.util.List;

public class OrderDetailsDTO implements Serializable {
	private int Id;
	private Product product;
	private int Quantity;
	private int TotalPrice;
	private String CreateTime;

	public OrderDetailsDTO() {
	}

	public OrderDetailsDTO(int id, Product product, int quantity, int totalPrice) {
		Id = id;
		this.product = product;
		Quantity = quantity;
		TotalPrice = totalPrice;
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

	public int getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
}

