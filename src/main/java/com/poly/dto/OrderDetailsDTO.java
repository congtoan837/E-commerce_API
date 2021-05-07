package com.poly.dto;

import com.poly.model.Product;

import java.io.Serializable;
import java.util.List;

public class OrderDetailsDTO implements Serializable {
	private int Id;
	private Product product;
	private int Quantity;
	private int TotalPrice;
	private String Brand;
	private String CreateTime;

	public OrderDetailsDTO() {
	}

	public OrderDetailsDTO(int id, Product product, int quantity, int totalPrice, String brand) {
		Id = id;
		this.product = product;
		Quantity = quantity;
		TotalPrice = totalPrice;
		Brand = brand;
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

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
}

