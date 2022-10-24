package com.project.picpayclone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ErrorDTO {

	public ErrorDTO(String field, String mensagem2) {
		// TODO Auto-generated constructor stub
	}

	private String campo;
	
	private String mensagem;
}
