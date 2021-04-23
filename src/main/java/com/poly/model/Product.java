package com.poly.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "Name", length = 50)
	private String Name;
	@Column(name = "Price")
	private int Price;
	@Column(name = "Image", length = 50)
	private String Image;
	@Column(name = "Description", length = 200)
	private String Description;
	@Column(name = "Status", length = 50)
	private String Status;

	@Column(name = "Quantity")
	private int Quantity;

	@ManyToOne
	@JoinColumn(name = "Brand")
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = "Category")
	private Category Category;
	
	public Product() {

	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public com.poly.model.Category getCategory() {
		return Category;
	}

	public void setCategory(com.poly.model.Category category) {
		Category = category;
	}
}
