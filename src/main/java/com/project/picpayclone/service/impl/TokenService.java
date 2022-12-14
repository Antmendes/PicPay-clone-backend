package com.project.picpayclone.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.project.picpayclone.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	@Value("${picpayclone.jwt.expiration}")
	private String expiration;
	
	@Value("${picpayclone.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authenticate) {
		Usuario usuarioLogado = (Usuario) authenticate.getPrincipal();
		Date hoje = new Date();
		Date tempoExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder().setIssuer("API PicPay Clone").setSubject(usuarioLogado.getId().toString())
				.setIssuedAt(tempoExpiracao).signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public Boolean isTokenValido(String token) {
		try {
		Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
		return true;
		}catch(Exception e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		Claims claims =  Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}
