package com.project.picpayclone.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Data;

@Data
public class LoginDTO {
	
	@NotBlank
	private String usuario;
	@NotBlank
	private String senha;
	
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(usuario, senha);
	}

}
