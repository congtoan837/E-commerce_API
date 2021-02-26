package com.poly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Promotion")
public class Promotion implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "percents")
	private int percents;
	@Column(name = "TimeStart")
	private String TimeStart;
	@Column(name = "TimeEnd")
	private String TimeEnd;
	@Column(name = "Description")
	private String Description;		
	
	public Promotion() {
		super();
	}
	public Promotion(int id, int percents, String timeStart, String timeEnd, String description) {
		super();
		Id = id;
		this.percents = percents;
		TimeStart = timeStart;
		TimeEnd = timeEnd;
		Description = description;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getPercents() {
		return percents;
	}
	public void setPercents(int percents) {
		this.percents = percents;
	}
	public String getTimeStart() {		
	    return TimeStart;
	}
	public void setTimeStart(String timeStart) {
		TimeStart = timeStart;
	}
	public String getTimeEnd() {		
	    return TimeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		TimeEnd = timeEnd;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

}
