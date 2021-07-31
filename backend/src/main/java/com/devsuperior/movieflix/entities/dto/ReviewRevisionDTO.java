package com.devsuperior.movieflix.entities.dto;

import java.io.Serializable;

public class ReviewRevisionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String text;
		
	public ReviewRevisionDTO() {
	}

	public ReviewRevisionDTO(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
}
