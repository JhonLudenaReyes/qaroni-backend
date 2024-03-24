package com.webservice.qaroni.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "people")
@Data
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Integer personId;
	
	@Column(length = 45, nullable = false)
	private String name;
	
	@Column(name = "last_name", length = 45, nullable = false)
	private String lastName;
	
	@Column(name = "identification_card", length = 10)
	private String identificationCard;
	
	@Column(columnDefinition = "varchar(1) not null default 'A'")
	private String state = "A";

}
