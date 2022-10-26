package com.project.picpayclone.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.picpayclone.dto.TransacaoDTO;
import com.project.picpayclone.service.ITransacaoService;


@RestController
@RequestMapping("/transacoes")
public class TransacaoController extends ControllerBase<TransacaoDTO> {

	@Autowired
	private ITransacaoService transacaoService;
	
	@PostMapping
	public ResponseEntity<TransacaoDTO> salvar(@RequestBody @Valid TransacaoDTO transacaoDTO, UriComponentsBuilder uriBuilder){   //@Valid valida as anotaçoes da classe TransacaoDTO(NOTNULL..)
		TransacaoDTO transacaoRetornoDTO = transacaoService.processar(transacaoDTO);
		return responderItemCriadoComURI(transacaoRetornoDTO, uriBuilder, "/transacoes/{codigo}", transacaoRetornoDTO.getCodigo());
	}
	
	@GetMapping
	public ResponseEntity<Page<TransacaoDTO>> listar(@PageableDefault(page = 0, size = 20) Pageable paginacao, // @PageableDefault define que os resultados serao paginados
			@RequestParam String login){
		Page<TransacaoDTO> transacoes = transacaoService.listar(paginacao, login);
		return responderListaDeItensPaginada(transacoes);
	}
	
}
