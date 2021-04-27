package com.poly.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@ManyToOne
	@JoinColumn(name = "ProductId")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "OrderId")
	private Orders orders;

	@Column(name = "Quantity")
	private int Quantity;

	@Column(name = "CreateTime")
	@Temporal(TemporalType.DATE)
	private Date createTime;
	
	public OrderDetails() {

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

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
