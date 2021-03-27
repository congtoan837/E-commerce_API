package com.poly.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "CustomerId")
	private int CustomerId;

	public Order() {
	}

	public Order(Integer id, int customerId) {
		Id = id;
		CustomerId = customerId;
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
}
