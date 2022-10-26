package com.project.picpayclone.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.project.picpayclone.enums.BandeiraCartao;

import lombok.Data;

@Data
public class CartaoCreditoDTO {

	@NotBlank
	private BandeiraCartao bandeira;
	
	@NotBlank
	private String codigoSeguranca;
	
	@NotBlank
	private String dataExpiracao;
	
	@NotBlank
	private String nomeTitular;
	
	private String numero;
	
	private String numeroToken;
	
	@NotNull
	private UsuarioDTO usuario;
	
	private Boolean isSalva = false;
	
	

	public BandeiraCartao getBandeira() {
		return bandeira;
	}

	public void setBandeira(BandeiraCartao bandeira) {
		this.bandeira = bandeira;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumeroToken() {
		return numeroToken;
	}

	public void setNumeroToken(String numeroToken) {
		this.numeroToken = numeroToken;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public Boolean getIsSalva() {
		return isSalva;
	}

	public void setIsSalva(Boolean isSalva) {
		this.isSalva = isSalva;
	}
	
	
	
}
