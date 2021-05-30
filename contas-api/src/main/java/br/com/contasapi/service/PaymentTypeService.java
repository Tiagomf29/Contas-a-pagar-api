package br.com.contasapi.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.PaymentType;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.GenericsCrud;
import br.com.contasapi.repository.PaymentTypeRepository;

@Service
public class PaymentTypeService implements GenericsCrud<PaymentType> {
	
	@Autowired
	PaymentTypeRepository paymentTypeRepository;

	@Override
	public HashMap<PaymentType, Integer> insert(PaymentType t) {
		return GenericsFunctions.returnMapByObjects(t, paymentTypeRepository.save(t).getCode());
	}

	@Override
	public HashMap<PaymentType, Integer> update(PaymentType t) {
		
		if(t.getCode() > 0) {	
			
			return GenericsFunctions.returnMapByObjects(t, paymentTypeRepository.save(t).getCode());			
		}
	  
		return GenericsFunctions.returnMapByObjects(t, 0);
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

	@Override
	public ArrayList<PaymentType> listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}




}
