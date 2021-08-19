package br.com.contasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.Income;

public interface IncomeRepository extends JpaRepository<Income, Integer>{

	List<Income>findById(int cod);	
	
}
