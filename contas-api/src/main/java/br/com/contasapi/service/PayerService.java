package br.com.contasapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.Payer;
import br.com.contasapi.genericsinterfaces.GenericsCrud;
import br.com.contasapi.repository.PayerRespository;

@Service
public class PayerService implements GenericsCrud<Payer>{

	@Autowired
	PayerRespository payerRepository;
		
	@Override
	public ResponseEntity<Payer> insert(Payer t) {
		return ResponseEntity.ok(payerRepository.save(t));	
	}

	@Override
	public ResponseEntity<Payer> update(Payer t) {		
		
		if(t.getCode() > 0) {	
			
			return ResponseEntity.ok(payerRepository.save(t));		
		}
	  
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Payer> delete(int id) {
		payerRepository.deleteById(id);		
		return ResponseEntity.noContent().build();
	}

	@Override
	public ArrayList<Payer> allList() {
		return (ArrayList<Payer>) payerRepository.findAll();
	}
	
}
