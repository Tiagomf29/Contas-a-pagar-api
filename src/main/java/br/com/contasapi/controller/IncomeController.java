package br.com.contasapi.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.Income;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.service.IncomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/incomes")
@Api(value = "Api Rest Renda")
@CrossOrigin(origins = "*")
public class IncomeController{

	@Autowired
	IncomeService incomeService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os registros de renda")
	public ArrayList<Income> listAllIncomes() {
		return incomeService.allList();
	}

	@PostMapping
	@ApiOperation(value = "Insere um registro de renda")	
	public ResponseEntity<Income> insertIncome(@Valid @RequestBody Income t) {
		return ResponseEntity.ok((Income) GenericsFunctions.returnObjectByMap(incomeService.insert(t)));
	}

	@PutMapping
	@ApiOperation(value = "Atualiza um registro de renda")
	public ResponseEntity<Income> updateIncome(@Valid@RequestBody Income t) {
		
		Income newPayer = (Income) GenericsFunctions.returnObjectByMap(incomeService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cod}")
	@ApiOperation(value = "Deleta um registro de renda")
	public ResponseEntity<Income> deleteIncome(@PathVariable int cod) {
		return incomeService.delete(cod); 
	}

	@GetMapping("/{cod}")
	@ApiOperation(value = "Lista um registro de renda por código")
	public ArrayList<Income> listConsultIdIncome(@PathVariable int cod) {
		return incomeService.listByCod(cod);
	}

}
