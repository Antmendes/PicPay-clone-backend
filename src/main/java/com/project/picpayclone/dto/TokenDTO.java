package com.project.picpayclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDTO {
	
	public TokenDTO(String token2, String string) {
		
	}
	private String token;
	private String tipo;

}
