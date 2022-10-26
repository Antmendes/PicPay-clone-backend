package com.project.picpayclone.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.picpayclone.conversor.TransacaoConversor;
import com.project.picpayclone.dto.TransacaoDTO;
import com.project.picpayclone.model.Transacao;
import com.project.picpayclone.repository.TransacaoRepository;
import com.project.picpayclone.service.ICartaoCreditoService;
import com.project.picpayclone.service.ITransacaoService;
import com.project.picpayclone.service.IUsuarioService;

@Service
public class TransacaoService implements ITransacaoService {

	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private TransacaoConversor transacaoConversor;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private ICartaoCreditoService cartaoCreditoService;
	
	@Override
	public TransacaoDTO processar(TransacaoDTO transacaoDTO) {
	    Transacao transacao = salvar(transacaoDTO);
	    cartaoCreditoService.salvar(transacaoDTO.getCartaoCredito());
	    usuarioService.atualizarSaldo(transacao, transacaoDTO.getIsCartaoCredito()); // atualiza o saldo de forma assincrona
		return transacaoConversor.converterEntidadeParaDto(transacao);
	}

	private Transacao salvar(TransacaoDTO transacaoDTO) {
		Transacao transacao = transacaoConversor.converterDtoParaEntidade(transacaoDTO);
		usuarioService.validar(transacao.getDestino(), transacao.getOrigem());
		return transacaoRepository.save(transacao);
		
	}

	@Override
	public Page<TransacaoDTO> listar(Pageable paginacao, String login) {
		Page<Transacao> transacoes = transacaoRepository.findByOrigem_LoginOrDestino_Login(login, login, paginacao);
		return transacaoConversor.converterPageEntidadeParaDto(transacoes);
	}

}
