package com.project.picpayclone.service;



import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.picpayclone.dto.TransacaoDTO;

public interface ITransacaoService {

	TransacaoDTO processar( TransacaoDTO transacaoDTO);
	
	Page<TransacaoDTO> listar(Pageable paginacao, String login);

}
