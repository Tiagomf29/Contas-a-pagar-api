package br.com.contasapi.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.BankAccount;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsCrud;
import br.com.contasapi.repository.BankRepository;

@Service
public class BankService implements InterfaceGenericsCrud<BankAccount> {

	@Autowired
	BankRepository bankRepository;
	
	@Override
	public HashMap<BankAccount, Integer> insert(BankAccount t) {
		
		return GenericsFunctions.returnMapByObjects(t, bankRepository.save(t).getCode());
	}

	@Override
	public HashMap<BankAccount, Integer> update(BankAccount t) {

		if(t.getCode() > 0) {	
			
			return GenericsFunctions.returnMapByObjects(t, bankRepository.save(t).getCode());			
		}
	  
		return GenericsFunctions.returnMapByObjects(t, 0);
	}

	@Override
	public ResponseEntity<BankAccount> delete(int id) {
		bankRepository.deleteById(id);		
		return ResponseEntity.noContent().build();
	}

	@Override
	public ArrayList<BankAccount> allList() {
		return (ArrayList<BankAccount>) bankRepository.findAll();
	}

	@Override
	public ArrayList<BankAccount> listByCod(int id) {
		return (ArrayList<BankAccount>) bankRepository.findById(id);
	}

}
