package com.project.picpayclone.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USUARIOS")
public class Usuario extends ModelBase{

	@Column(name = "USUA_LOGIN", nullable = false)
	private String login;
	
	@Column(name = "USUA_SENHA", nullable = false)
	private String senha;
	
	@Column(name = "USUA_EMAIL", nullable = false)
	private String email;
	
	@Column(name = "USUA_NOME_COMPLETO", nullable = false)
	private String nomeCompleto;
	
	@Column(name = "USUA_CPF", nullable = false)
	private String cpf;
	
	@Column(name = "USUA_DATA_NASCIMENTO", nullable = false)
	private LocalDate dataNascimento;
	
	@Column(name = "USUA_NUMERO_TELEFONE", nullable = false)
	private String numeroTelefone;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<CartaoCredito> cartoesCredito;
	
	@Column(name = "USUA_SALDO", nullable = false)
	private Double saldo;
	
	@Column(name = "USUA_ATIVO", nullable = false)
	private Boolean ativo;
}
