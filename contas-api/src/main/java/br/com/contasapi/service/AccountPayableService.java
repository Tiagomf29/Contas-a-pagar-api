package br.com.contasapi.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.AccountPayable;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsCrud;
import br.com.contasapi.repository.AccountPayableRepository;

@Service
public class AccountPayableService implements InterfaceGenericsCrud<AccountPayable>{

	@Autowired
	AccountPayableRepository accountPayableRespository;
	
	@Override
	public HashMap<AccountPayable, Integer> insert(AccountPayable t) {
		return GenericsFunctions.returnMapByObjects(t, accountPayableRespository.save(t).getCode());	
	}

	@Override
	public HashMap<AccountPayable, Integer> update(AccountPayable t) {
		
		if(t.getCode() > 0) {	
			
			return GenericsFunctions.returnMapByObjects(t, accountPayableRespository.save(t).getCode());			
		}
	  
		return GenericsFunctions.returnMapByObjects(t, 0);
	}

	@Override
	public ResponseEntity<AccountPayable> delete(int id) {
		accountPayableRespository.deleteById(id);		
		return ResponseEntity.noContent().build();
	}

	@Override
	public ArrayList<AccountPayable> allList() {
		return (ArrayList<AccountPayable>) accountPayableRespository.findAll();
	}

	@Override
	public ArrayList<AccountPayable> listByCod(int id) {
		return (ArrayList<AccountPayable>) accountPayableRespository.findById(id);
	}

}
