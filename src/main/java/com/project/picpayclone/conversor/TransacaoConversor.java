package com.project.picpayclone.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.project.picpayclone.dto.TransacaoDTO;
import com.project.picpayclone.model.Transacao;
import com.project.picpayclone.service.IUsuarioService;

@Component
public class TransacaoConversor extends ConversorBase<Transacao, TransacaoDTO> {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Override
	public TransacaoDTO converterEntidadeParaDto(Transacao entidade) {  //faz a conversao automatica
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Transacao, TransacaoDTO>(){
			@Override
			protected void configure() {
				
			}
		});
		return modelMapper.map(entidade, TransacaoDTO.class);
	}
	
	@SuppressWarnings("unchecked")
	public Page<TransacaoDTO> converterPageEntidadeParaDto(Page<Transacao> entidade){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Page<Transacao>, Page<TransacaoDTO>>(){
			@Override
			protected void configure() {
				
			}
		});
		
		return modelMapper.map(entidade, Page.class);
	}
	
	@Override
	public Transacao converterDtoParaEntidade(TransacaoDTO dto) {  //faz a conversao automatica
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<TransacaoDTO, Transacao>(){
			@Override
			protected void configure() {
				
			}
		});
		return modelMapper.map(dto, Transacao.class);
	
}}
