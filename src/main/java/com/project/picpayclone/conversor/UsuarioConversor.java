package com.project.picpayclone.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.project.picpayclone.dto.CartaoCreditoDTO;
import com.project.picpayclone.dto.TransacaoDTO;
import com.project.picpayclone.dto.UsuarioDTO;
import com.project.picpayclone.model.Transacao;
import com.project.picpayclone.model.Usuario;

@Component
public class UsuarioConversor extends ConversorBase<Usuario, UsuarioDTO>{

	@Override
	public UsuarioDTO converterEntidadeParaDto(Usuario entidade) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Usuario, UsuarioDTO>(){
			@Override
			protected void configure() {
				
			}
		});
		
		return modelMapper.map(entidade, UsuarioDTO.class);
	}

	@Override
	public Usuario converterDtoParaEntidade(UsuarioDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<UsuarioDTO, Usuario>(){
			@Override
			protected void configure() {
				
			}
		});
		
		return modelMapper.map(dto, Usuario.class);
	}
	
}
