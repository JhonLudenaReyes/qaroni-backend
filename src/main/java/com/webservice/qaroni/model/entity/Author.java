package com.webservice.qaroni.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "authors")
@Data
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private Integer authorId;
	
	@Column(name = "person_id")
	private Integer personId;
	
	@Column(length = 45)
	private String address;
	
	@Column(length = 45)
	private String website;
	
	@Column(columnDefinition = "varchar(1) not null default 'A'")
	private String state = "A";
	
	@OneToOne
	@JoinColumn(name = "person_id", insertable = false, updatable = false)
	private Person person;
	

}
