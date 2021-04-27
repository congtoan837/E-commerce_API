package com.poly.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
public class Cart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@ManyToOne
	@JoinColumn(name = "CustomerId")
	private Users user;

	@Column(name = "CreateTime")
	@Temporal(TemporalType.DATE)
	private Date createTime;

	public Cart() {
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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
