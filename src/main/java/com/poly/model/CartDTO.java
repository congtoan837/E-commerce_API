package com.poly.model;

import java.io.Serializable;

public class CartDTO implements Serializable{
	private Integer Id;
	private Integer IdCustomer;
	private String NameCustomer;
	private String PhoneCustomer;
	private Integer IdProduct;
	private String NameProduct;
	private String ImageProduct;
	private int QuantityProduct;
	private int QuantityBuy;
		
	public CartDTO() {
		super();
	}
	public CartDTO(Integer id, Integer idCustomer, String nameCustomer, String phoneCustomer, Integer idProduct,
			String nameProduct, String imageProduct, int quantityProduct, int quantityBuy) {
		super();
		Id = id;
		IdCustomer = idCustomer;
		NameCustomer = nameCustomer;
		PhoneCustomer = phoneCustomer;
		IdProduct = idProduct;
		NameProduct = nameProduct;
		ImageProduct = imageProduct;
		QuantityProduct = quantityProduct;
		QuantityBuy = quantityBuy;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getIdCustomer() {
		return IdCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		IdCustomer = idCustomer;
	}
	public String getNameCustomer() {
		return NameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		NameCustomer = nameCustomer;
	}
	public String getPhoneCustomer() {
		return PhoneCustomer;
	}
	public void setPhoneCustomer(String phoneCustomer) {
		PhoneCustomer = phoneCustomer;
	}
	public Integer getIdProduct() {
		return IdProduct;
	}
	public void setIdProduct(Integer idProduct) {
		IdProduct = idProduct;
	}
	public String getNameProduct() {
		return NameProduct;
	}
	public void setNameProduct(String nameProduct) {
		NameProduct = nameProduct;
	}
	public String getImageProduct() {
		return ImageProduct;
	}
	public void setImageProduct(String imageProduct) {
		ImageProduct = imageProduct;
	}
	public int getQuantityProduct() {
		return QuantityProduct;
	}
	public void setQuantityProduct(int quantityProduct) {
		QuantityProduct = quantityProduct;
	}
	public int getQuantityBuy() {
		return QuantityBuy;
	}
	public void setQuantityBuy(int quantityBuy) {
		QuantityBuy = quantityBuy;
	}
}
