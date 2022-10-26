package com.project.picpayclone.service;

import java.util.List;

import com.project.picpayclone.dto.UsuarioDTO;
import com.project.picpayclone.model.Transacao;
import com.project.picpayclone.model.Usuario;

public interface IUsuarioService {

	Usuario consultarEntidade(String login);

	void validar(Usuario... usuarios);

	void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito);

	UsuarioDTO consultar(String login);

	List<UsuarioDTO> listar(String login);
}
