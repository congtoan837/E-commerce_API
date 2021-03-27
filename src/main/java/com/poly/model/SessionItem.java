package com.poly.model;

public class SessionItem {

	private Product product;
	private int quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public SessionItem() {
	}

	public SessionItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

}
