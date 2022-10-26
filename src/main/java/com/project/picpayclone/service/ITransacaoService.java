package com.project.picpayclone.service;

import java.awt.print.Pageable;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.project.picpayclone.dto.TransacaoDTO;

public interface ITransacaoService {

	TransacaoDTO processar( TransacaoDTO transacaoDTO);
	
	Page<TransacaoDTO> listar(Pageable paginacao, String login);

}
