package br.com.contasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.AccountPayable;

public interface AccountPayableRepository extends JpaRepository<AccountPayable, Integer>{
	List<AccountPayable>findById(int cod);	
}
