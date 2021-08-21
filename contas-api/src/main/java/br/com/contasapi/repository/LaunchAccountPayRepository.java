package br.com.contasapi.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.LaunchAccountPay;

public interface LaunchAccountPayRepository extends JpaRepository<LaunchAccountPay, Integer> {
	ArrayList<LaunchAccountPay> findById(int cod);
}
