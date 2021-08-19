package br.com.contasapi.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.Income;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsCrud;
import br.com.contasapi.repository.IncomeRepository;

@Service
public class IncomeService implements InterfaceGenericsCrud<Income>{

	@Autowired
	IncomeRepository incomeRepository;
	
	@Override
	public HashMap<Income, Integer> insert(Income t) {
		return GenericsFunctions.returnMapByObjects(t, incomeRepository.save(t).getCode());	
	}

	@Override
	public HashMap<Income, Integer> update(Income t) {
		
		if(t.getCode() > 0) {	
			
			return GenericsFunctions.returnMapByObjects(t, incomeRepository.save(t).getCode());			
		}
	  
		return GenericsFunctions.returnMapByObjects(t, 0);
	}

	@Override
	public ResponseEntity<Income> delete(int id) {
		incomeRepository.deleteById(id);		
		return ResponseEntity.noContent().build();
	}

	@Override
	public ArrayList<Income> allList() {
		return (ArrayList<Income>) incomeRepository.findAll();
	}

	@Override
	public ArrayList<Income> listByCod(int id) {
		return (ArrayList<Income>) incomeRepository.findById(id);
	}

}
