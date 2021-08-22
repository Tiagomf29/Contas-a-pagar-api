package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.Income;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.IncomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/income")
@Api(value = "Api Rest Renda")
@CrossOrigin(origins = "*")
public class IncomeController implements InterfaceGenericsController<Income>{

	@Autowired
	IncomeService incomeService;
	
	@Override
	@ApiOperation(value = "Lista todos os registros de renda")
	public ArrayList<Income> listAllController() {
		return incomeService.allList();
	}

	@Override
	@ApiOperation(value = "Insere um registro de renda")	
	public ResponseEntity<Income> insertController(Income t) {
		return ResponseEntity.ok((Income) GenericsFunctions.returnObjectByMap(incomeService.insert(t)));
	}

	@Override
	@ApiOperation(value = "Atualiza um registro de renda")
	public ResponseEntity<Income> updateController(Income t) {
		
		Income newPayer = (Income) GenericsFunctions.returnObjectByMap(incomeService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	@ApiOperation(value = "Deleta um registro de renda")
	public ResponseEntity<Income> deleteController(int cod) {
		return incomeService.delete(cod); 
	}

	@Override
	@ApiOperation(value = "Lista um registro de renda por código")
	public ArrayList<Income> listConsultIdController(int cod) {
		return incomeService.listByCod(cod);
	}

}
