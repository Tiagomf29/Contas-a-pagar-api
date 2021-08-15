package br.com.contasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.BankAccount;

public interface BankRepository extends JpaRepository<BankAccount, Integer>{
	
	List<BankAccount>findById(int cod);	
}
