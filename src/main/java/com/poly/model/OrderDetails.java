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
	@Column(name = "Quantity")
	private int Quantity;
	@Column(name = "TotalPrice")
	private int TotalPrice;
	@Column(name = "ProductId")
	private int ProductId;
	@Column(name = "PromotionId")
	private int PromotionId;
	@Column(name = "CustomerId")
	private int CustomerId;
	@Column(name = "Status")
	private String Status;
	@Column(name = "PaymentId")
	private int PaymentId;
	@Column(name = "CreateTime")
	private String CreateTime;

	
	
	public OrderDetails() {
		super();
	}
	public OrderDetails(int id, int quantity, int totalPrice, int productId, int promotionId,
			int customerId, String status, int paymentId, String createTime) {
		super();
		Id = id;
		Quantity = quantity;
		TotalPrice = totalPrice;
		ProductId = productId;
		PromotionId = promotionId;
		CustomerId = customerId;
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
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getPromotionId() {
		return PromotionId;
	}
	public void setPromotionId(int promotionId) {
		PromotionId = promotionId;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
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
