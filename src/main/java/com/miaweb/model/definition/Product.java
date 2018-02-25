package com.miaweb.model.definition;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.miaweb.model.CustomLocalDateTimeSerializer;
import com.miaweb.model.RecordStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "pstkmc")
@NamedQuery(name = "Product.deneme", query = "select p from Product p where p.code = ?1")
@Data
public class Product implements Serializable{ //extends BaseEntity {
	@Id
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequenceName", value = "seq_product_id"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"),
	})
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	//@GeneratedValue
	private Long id;

	@Column(name = "pmckod", unique = true, length = 15)
	private String code;

	@Column(name = "pmcadi", unique = true, length = 50)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date expireDate = new Date();

	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	public LocalDateTime exemptDate;

	@Column(name = "status", length = 20)
	@Enumerated(EnumType.STRING)
	private RecordStatus status;
}
