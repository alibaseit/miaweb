package com.miaweb.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;

@MappedSuperclass
public class BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@CreatedDate
	private Date createdDate = new Date();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
