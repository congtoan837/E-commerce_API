package com.poly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "ProductId")
	private int ProductId;
	@Column(name = "Quantity")
	private int Quantity;
	@Column(name = "OrderId")
	private int OrderId;
	
	public OrderDetails() {

	}

	public OrderDetails(int id, int productId, int quantity, int orderId) {
		Id = id;
		ProductId = productId;
		Quantity = quantity;
		OrderId = orderId;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) { ProductId = productId; }
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

}
