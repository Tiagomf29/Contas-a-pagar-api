package br.com.contasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {

	List<PaymentType>findByDescription(String name);
	List<PaymentType>findByCode(int cod);
}
