package br.com.contasapi.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.Payer;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.GenericsCrud;
import br.com.contasapi.repository.PayerRespository;

@Service
public class PayerService implements GenericsCrud<Payer>{

	@Autowired
	PayerRespository payerRepository;
	@Override
	public HashMap<Payer, Integer> insert(Payer t) {				
		return GenericsFunctions.returnMapByObjects(t, payerRepository.save(t).getCode());	
	}	

	@Override
	public HashMap<Payer, Integer> update(Payer t) {
		
		if(t.getCode() > 0) {	
			
			return GenericsFunctions.returnMapByObjects(t, payerRepository.save(t).getCode());			
		}
	  
		return GenericsFunctions.returnMapByObjects(t, 0);
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

	@Override
	public ArrayList<Payer> listByCod(int cod) {
		return (ArrayList<Payer>) payerRepository.findById(cod); 
	}

}
