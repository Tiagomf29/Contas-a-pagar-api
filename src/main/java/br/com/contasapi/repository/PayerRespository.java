package br.com.contasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.contasapi.domain.Payer;

@Repository
public interface PayerRespository extends JpaRepository<Payer, Integer>{

	List<Payer>findByName(String name);
	List<Payer>findById(int cod);
	
	@Query(value = "select * from payer where code = 1 ", nativeQuery = true)
	List<Payer> listaPayer(); 
}
