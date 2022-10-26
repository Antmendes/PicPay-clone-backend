package com.project.picpayclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.picpayclone.dto.UsuarioDTO;
import com.project.picpayclone.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends ControllerBase<UsuarioDTO>{

	@Autowired
	private IUsuarioService usuarioService;
	
	
	@GetMapping("/{login}")
	public ResponseEntity<UsuarioDTO> consultar(@PathVariable String login){
		UsuarioDTO usuario = usuarioService.consultar(login);
		return responderSucessoComItem(usuario);
	}
	
	@GetMapping("/contatos")
	public ResponseEntity<List<UsuarioDTO>> Listar(@RequestParam String login){
		List<UsuarioDTO> usuarios = usuarioService.listar(login);
		return responderListaDeItens(usuarios);
	}
	
	@GetMapping("/{login}/saldo")
	public ResponseEntity<UsuarioDTO> consultarSaldo(@PathVariable String login){
		UsuarioDTO usuarioDTO = usuarioService.consultar(login);
		return responderSucessoComItem(usuarioDTO);
	}
}
