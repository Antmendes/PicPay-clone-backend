package com.project.picpayclone.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.picpayclone.dto.CartaoCreditoDTO;
import com.project.picpayclone.dto.TransacaoDTO;
import com.project.picpayclone.model.CartaoCredito;
import com.project.picpayclone.model.Transacao;
import com.project.picpayclone.service.IUsuarioService;
import com.project.picpayclone.util.CartaoCreditoUtil;

@Component
public class CartaoCreditoConversor extends ConversorBase<CartaoCredito, CartaoCreditoDTO>{

	@Autowired
	private IUsuarioService usuarioService;
	
	
	@Override
	public CartaoCreditoDTO converterEntidadeParaDto(CartaoCredito entidade) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Transacao, TransacaoDTO>(){
			@Override
			protected void configure() {
				
			}
		});
		
		return modelMapper.map(entidade, CartaoCreditoDTO.class);
	}

	@Override
	public CartaoCredito converterDtoParaEntidade(CartaoCreditoDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<TransacaoDTO,Transacao>(){
			@Override
			protected void configure() {
				
			}
		});
		
		return modelMapper.map(dto, CartaoCredito.class);
	}
}
