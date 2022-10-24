package com.project.picpayclone.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ModelBase {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
