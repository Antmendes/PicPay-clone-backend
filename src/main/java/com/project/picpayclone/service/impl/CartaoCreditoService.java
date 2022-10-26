package com.project.picpayclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.picpayclone.conversor.CartaoCreditoConversor;
import com.project.picpayclone.dto.CartaoCreditoDTO;
import com.project.picpayclone.model.CartaoCredito;
import com.project.picpayclone.repository.CartaoCreditoRepository;
import com.project.picpayclone.service.ICartaoCreditoService;
import com.project.picpayclone.service.IUsuarioService;

public class CartaoCreditoService implements ICartaoCreditoService{

	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;
	
	@Autowired
	private CartaoCreditoConversor cartaoCreditoConversor;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	
	@Override
	public CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCreditoDTO) {
		CartaoCreditoDTO cartaoCreditoRetorno = null;
		if (cartaoCreditoDTO.getIsSalva()) {
			CartaoCredito cartaoCredito = cartaoCreditoConversor.converterDtoParaEntidade(cartaoCreditoDTO);
			usuarioService.validar(cartaoCredito.getUsuario());
			CartaoCredito cartaoCreditoSalvo = cartaoCreditoRepository.save(cartaoCredito);
			cartaoCreditoRetorno = cartaoCreditoConversor.converterEntidadeParaDto(cartaoCreditoSalvo);
		}
		
		return cartaoCreditoRetorno;
	}

}
