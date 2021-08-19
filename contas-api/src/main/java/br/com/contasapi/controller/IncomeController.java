package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.Income;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.IncomeService;

@RestController
@RequestMapping("/income")
public class IncomeController implements InterfaceGenericsController<Income>{

	@Autowired
	IncomeService incomeService;
	
	@Override
	public ArrayList<Income> listAllController() {
		return incomeService.allList();
	}

	@Override
	public ResponseEntity<Income> insertController(Income t) {
		return ResponseEntity.ok((Income) GenericsFunctions.returnObjectByMap(incomeService.insert(t)));
	}

	@Override
	public ResponseEntity<Income> updateController(Income t) {
		
		Income newPayer = (Income) GenericsFunctions.returnObjectByMap(incomeService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Income> deleteController(int cod) {
		return incomeService.delete(cod); 
	}

	@Override
	public ArrayList<Income> listConsultIdController(int cod) {
		return incomeService.listByCod(cod);
	}

}
