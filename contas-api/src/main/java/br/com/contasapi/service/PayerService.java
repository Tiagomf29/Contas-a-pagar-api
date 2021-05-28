package br.com.contasapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.Payer;
import br.com.contasapi.repository.PayerRespository;

@Service
public class PayerService {

	@Autowired
	PayerRespository payerRepository;
	
	public ResponseEntity<Payer> insertPayer(Payer payer) {		
		return ResponseEntity.ok(payerRepository.save(payer));		
	}
	
	public ArrayList<Payer> allListPayers(){		
		return (ArrayList<Payer>) payerRepository.findAll();	    		
	}
	
	public ResponseEntity<Payer> updatePayer(Payer payer) {
		
		if(payer.getCode() > 0) {
			return ResponseEntity.ok(payerRepository.save(payer));		
		}
	  
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<Payer>deletePayer(int cod){
		
		payerRepository.deleteById(cod);
		
		return ResponseEntity.noContent().build();
	}
	
}
