package com.poly.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Payment")
public class Payment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "Name", length = 50)
	private String Name;
	@Column(name = "Description", length = 50)
	private String Description;

	@Column(name = "CreateTime")
	@Temporal(TemporalType.DATE)
	private Date createTime;

	public Payment() {
	}

	public Payment(int id, String name, String description) {
		Id = id;
		Name = name;
		Description = description;
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

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
