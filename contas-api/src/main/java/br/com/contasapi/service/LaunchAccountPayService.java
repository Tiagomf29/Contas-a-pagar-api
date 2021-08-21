package br.com.contasapi.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.LaunchAccountPay;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsCrud;
import br.com.contasapi.repository.LaunchAccountPayRepository;

@Service
public class LaunchAccountPayService implements InterfaceGenericsCrud<LaunchAccountPay>{
	@Autowired
	LaunchAccountPayRepository launchAccountPayRepository;
	
	@Override
	public HashMap<LaunchAccountPay, Integer> insert(LaunchAccountPay t) {
		return GenericsFunctions.returnMapByObjects(t, launchAccountPayRepository.save(t).getCode());	
	}

	@Override
	public HashMap<LaunchAccountPay, Integer> update(LaunchAccountPay t) {
		
		if(t.getCode() > 0) {	
			
			return GenericsFunctions.returnMapByObjects(t, launchAccountPayRepository.save(t).getCode());			
		}
	  
		return GenericsFunctions.returnMapByObjects(t, 0);
	}

	@Override
	public ResponseEntity<LaunchAccountPay> delete(int id) {
		launchAccountPayRepository.deleteById(id);		
		return ResponseEntity.noContent().build();
	}

	@Override
	public ArrayList<LaunchAccountPay> allList() {
		return (ArrayList<LaunchAccountPay>) launchAccountPayRepository.findAll();
	}

	@Override
	public ArrayList<LaunchAccountPay> listByCod(int id) {
		return launchAccountPayRepository.findById(id);
	}

}
