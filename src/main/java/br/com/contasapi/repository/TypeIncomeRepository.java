package br.com.contasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.TypeIncome;

public interface TypeIncomeRepository extends JpaRepository<TypeIncome, Integer>{
	
	List<TypeIncome>findByDescription(String name);
	List<TypeIncome>findByCode(int cod);	

}
