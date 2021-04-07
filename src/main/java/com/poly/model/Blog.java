package com.poly.model;

import com.sun.istack.NotNull;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Valid
@Entity
@Table(name = "Blog",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "Title")
		})
public class Blog implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "Title")
    private String Title;
	@Column(name = "Image")
    private String Image;
	@Column(name = "Content")
    private String Content;
	@Column(name = "Description")
    private String Description;
	@Column(name = "CreateBy")
    private int CreateBy;
	
	public Blog() {
		super();
	}

	public Blog(Integer id, String title, String image, String content, String description, int createBy) {
		super();
		Id = id;
		Title = title;
		Image = image;
		Content = content;
		Description = description;
		CreateBy = createBy;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getCreateBy() {
		return CreateBy;
	}

	public void setCreateBy(int createBy) {
		CreateBy = createBy;
	}
}

