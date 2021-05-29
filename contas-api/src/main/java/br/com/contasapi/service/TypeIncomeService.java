package br.com.contasapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.TypeIncome;
import br.com.contasapi.genericsinterfaces.GenericsCrud;
import br.com.contasapi.repository.TypeIncomeRepository;

@Service
public class TypeIncomeService implements GenericsCrud<TypeIncome>{

	@Autowired
	TypeIncomeRepository typeIncomeRepository;
	
	@Override
	public ResponseEntity<TypeIncome> insert(TypeIncome t) {
		return ResponseEntity.ok(typeIncomeRepository.save(t));
	}

	@Override
	public ResponseEntity<TypeIncome> update(TypeIncome t) {
		if(t.getCode() > 0) {	
			
			return ResponseEntity.ok(typeIncomeRepository.save(t));		
		}
	  
		return ResponseEntity.notFound().build();
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

}
