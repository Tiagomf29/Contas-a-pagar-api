package br.com.contasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {

}
