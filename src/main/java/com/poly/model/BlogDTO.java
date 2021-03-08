package com.poly.model;

import java.io.Serializable;

public class BlogDTO implements Serializable{
	private Integer Id;
	private Integer IdAmin;
	private String Name;
    private String Title;
    private String Image;
    private String Content;
    private String Description;   
    
	public BlogDTO(Integer id, Integer idAmin, String name, String title, String image,
			String content, String description) {
		super();
		Id = id;
		IdAmin = idAmin;
		Name = name;
		Title = title;
		Image = image;
		Content = content;
		Description = description;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	public Integer getIdAmin() {
		return IdAmin;
	}
	public void setIdAmin(Integer idAmin) {
		IdAmin = idAmin;
	}
    
}
