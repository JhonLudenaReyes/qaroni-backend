package com.webservice.qaroni.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "books_authors")
@Data
public class BookAuthor {
	
	@EmbeddedId
	private BookAuthorId bookAuthorId;

}
