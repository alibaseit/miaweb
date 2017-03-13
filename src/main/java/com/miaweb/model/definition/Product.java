package com.miaweb.model.definition;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miaweb.model.BaseEntity;

@Entity
@Table(name = "pstkmc")
@NamedQuery(name = "Product.deneme", query = "select p from Product p where p.code = ?1")
public class Product extends BaseEntity {

	@Column(name = "pmckod", unique = true, length = 15)
	private String code;
	@Column(name = "pmcadi", unique = true, length = 50)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
	private Date expireDate = new Date();

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
