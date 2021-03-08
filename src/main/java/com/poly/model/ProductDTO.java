package com.poly.model;

import java.io.Serializable;

public class ProductDTO implements Serializable{
	private Integer Id;
	private Integer IdBrand;
	private Integer IdCategory;
	private String Name;
	private int Price;
	private String Image;
	private String Description;
	private String Status;
	private String Brand;
	private int Quantity;
	private String Category;
	
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(Integer id, Integer idBrand, Integer idCategory, String name, int price, String image,
			String description, String status, String brand, int quantity, String category) {
		super();
		Id = id;
		IdBrand = idBrand;
		IdCategory = idCategory;
		Name = name;
		Price = price;
		Image = image;
		Description = description;
		Status = status;
		Brand = brand;
		Quantity = quantity;
		Category = category;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getIdBrand() {
		return IdBrand;
	}
	public void setIdBrand(Integer idBrand) {
		IdBrand = idBrand;
	}
	public Integer getIdCategory() {
		return IdCategory;
	}
	public void setIdCategory(Integer idCategory) {
		IdCategory = idCategory;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
}
