package com.project.picpayclone.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.picpayclone.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

	Page<Transacao> findByOrigem_LoginOrDestino_Login(String login, String login2, Pageable paginacao);

}
