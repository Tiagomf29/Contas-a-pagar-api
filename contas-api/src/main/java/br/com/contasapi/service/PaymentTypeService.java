package br.com.contasapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.PaymentType;
import br.com.contasapi.genericsinterfaces.GenericsCrud;
import br.com.contasapi.repository.PaymentTypeRepository;

@Service
public class PaymentTypeService implements GenericsCrud<PaymentType> {
	
	@Autowired
	PaymentTypeRepository paymentTypeRepository;

	@Override
	public ResponseEntity<PaymentType> insert(PaymentType t) {
		return ResponseEntity.ok(paymentTypeRepository.save(t));
	}

	@Override
	public ResponseEntity<PaymentType> update(PaymentType t) {
		return ResponseEntity.ok(paymentTypeRepository.save(t));
	}

	@Override
	public ResponseEntity<PaymentType> delete(int id) {
		paymentTypeRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@Override
	public ArrayList<PaymentType> allList() {
		return (ArrayList<PaymentType>) paymentTypeRepository.findAll();
	}

}
