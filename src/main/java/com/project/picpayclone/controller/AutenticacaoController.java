package com.project.picpayclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.picpayclone.dto.LoginDTO;
import com.project.picpayclone.dto.TokenDTO;
import com.project.picpayclone.service.impl.TokenService;


@RestController
@RequestMapping("/login")
public class AutenticacaoController extends ControllerBase<TokenDTO>{
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	public ResponseEntity<TokenDTO> autenticar(LoginDTO login){
		UsernamePasswordAuthenticationToken dadosLogin = login.converter();
		
		try {
		Authentication authenticate = authManager.authenticate(dadosLogin);
		String token = tokenService.gerarToken(authenticate);
		return responderSucessoComItem(new TokenDTO(token, "Bearer"));
		} catch (AuthenticationException e) {
			return responderRequisicaoMalSucedida();
		}
	}

}
