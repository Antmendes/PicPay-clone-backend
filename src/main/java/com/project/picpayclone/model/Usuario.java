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
	private List<CartaoCredito> cartoesCredito;// fetch.LAZY não traz tudo na busca, MERGE ja atualiza qdo houver
	                                                         // orphanRemoval remove o cartao se o usuario for excluido
	@Column(name = "USUA_SALDO", nullable = false)
	private Double saldo;
	
	@Column(name = "USUA_ATIVO", nullable = false)
	private Boolean ativo;
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public List<CartaoCredito> getCartoesCredito() {
		return cartoesCredito;
	}

	public void setCartoesCredito(List<CartaoCredito> cartoesCredito) {
		this.cartoesCredito = cartoesCredito;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
}
