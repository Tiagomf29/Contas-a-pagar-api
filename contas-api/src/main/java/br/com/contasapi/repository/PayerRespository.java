package br.com.contasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.Payer;

public interface PayerRespository extends JpaRepository<Payer, Integer>{

}
