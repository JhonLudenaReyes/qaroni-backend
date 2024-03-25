package com.webservice.qaroni.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class BookAuthorId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "book_id")
	private Integer bookId;
	
	@Column(name = "author_id")
	private Integer authorId;

}
