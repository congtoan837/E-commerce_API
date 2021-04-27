package com.poly.model;

import com.sun.istack.NotNull;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.*;
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

	@NotBlank
	@Column(name = "Content")
    private String Content;

	@Column(name = "Description")
    private String Description;

	@ManyToOne
	@JoinColumn(name = "CreateBy")
	private Users user;

	@Column(name = "CreateTime")
	@Temporal(TemporalType.DATE)
	private Date createTime;

	public Blog() {
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}

