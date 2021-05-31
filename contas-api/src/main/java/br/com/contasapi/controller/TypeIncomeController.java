package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.TypeIncome;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.GenericsController;
import br.com.contasapi.service.TypeIncomeService;

@RestController
@RequestMapping("/typeIncome")
public class TypeIncomeController implements GenericsController<TypeIncome>{

	@Autowired
	TypeIncomeService typeIncomeService;
	
	@Override
	public ArrayList<TypeIncome> listAllController() {
		return typeIncomeService.allList();
	}

	@Override
	public ResponseEntity<TypeIncome> insertController(TypeIncome t) {
		return ResponseEntity.ok((TypeIncome) GenericsFunctions.returnObjectByMap(typeIncomeService.insert(t)));
	}

	@Override
	public ResponseEntity<TypeIncome> updateController(TypeIncome t) {
		
		TypeIncome newTypeIncome = (TypeIncome) GenericsFunctions.returnObjectByMap(typeIncomeService.update(t));
		
		if(newTypeIncome.getCode() != 0) {
			return ResponseEntity.ok(newTypeIncome);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<TypeIncome> deleteController(int cod) {
		return typeIncomeService.delete(cod);
	}

	@Override
	public ArrayList<TypeIncome> listConsultIdController(int id) {
		return typeIncomeService.listByCod(id);
	}

}
