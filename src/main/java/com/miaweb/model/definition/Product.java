package com.miaweb.model.definition;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.miaweb.model.BaseEntity;
import com.miaweb.model.CustomLocalDateTimeSerializer;
import com.miaweb.model.RecordStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
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
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	public LocalDateTime exemptDate;
	@Enumerated(EnumType.STRING)
	private RecordStatus status;
}
