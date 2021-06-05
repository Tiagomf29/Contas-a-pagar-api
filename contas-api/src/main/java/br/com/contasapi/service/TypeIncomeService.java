package br.com.contasapi.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.TypeIncome;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsCrud;
import br.com.contasapi.repository.TypeIncomeRepository;

@Service
public class TypeIncomeService implements InterfaceGenericsCrud<TypeIncome>{

	@Autowired
	TypeIncomeRepository typeIncomeRepository;
	
	@Override
	public HashMap<TypeIncome, Integer> insert(TypeIncome t) {		
		return GenericsFunctions.returnMapByObjects(t, typeIncomeRepository.save(t).getCode());	
	}

	@Override
	public HashMap<TypeIncome, Integer> update(TypeIncome t) {
		
		if(t.getCode() > 0) {	
			
			return GenericsFunctions.returnMapByObjects(t, typeIncomeRepository.save(t).getCode());			
		}
	  
		return GenericsFunctions.returnMapByObjects(t, 0);
	}

	@Override
	public ResponseEntity<TypeIncome> delete(int id) {
		typeIncomeRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ArrayList<TypeIncome> allList() {
		return (ArrayList<TypeIncome>) typeIncomeRepository.findAll();
	}

	@Override
	public ArrayList<TypeIncome> listByCod(int id) {
		// TODO Auto-generated method stub
		return (ArrayList<TypeIncome>) typeIncomeRepository.findByCode(id);
	}



}
