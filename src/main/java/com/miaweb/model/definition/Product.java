package com.miaweb.model.definition;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miaweb.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pstkmc")
@NamedQuery(name = "Product.deneme", query = "select p from Product p where p.code = ?1")
@Data
public class Product extends BaseEntity {
	@Column(name = "pmckod", unique = true, length = 15)
	private String code;

	@Column(name = "pmcadi", unique = true, length = 50)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
	private Date expireDate = new Date();
}
