package com.poly.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Brand")
public class Brand implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "Name", length = 50)
    private String Name;

	@Column(name = "CreateTime")
	@Temporal(TemporalType.DATE)
	private Date createTime;
	
	public Brand() {
		super();
	}

	public Brand(Integer id, String name, String password) {
		super();
		Id = id;
		Name = name;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
