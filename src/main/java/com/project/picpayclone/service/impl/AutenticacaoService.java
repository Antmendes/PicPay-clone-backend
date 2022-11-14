package com.project.picpayclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.picpayclone.MensagemValidacao;
import com.project.picpayclone.model.Usuario;

public class AutenticacaoService implements UserDetailsService{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.consultarEntidade(login);
		
		if(!validarUsuario(usuario)) {
			throw new UsernameNotFoundException(MensagemValidacao.ERRO_USUARIO_SEM_PERMISSAO);
		}
		
		return usuario;
	}
	
	private boolean validarUsuario(Usuario usuario) {
		boolean usuarioValido = false;
		
		if(usuario != null && usuario.getPermissao() != null && usuario.getAtivo()) {
			usuarioValido = true;
		}
		return usuarioValido;
	}

}
