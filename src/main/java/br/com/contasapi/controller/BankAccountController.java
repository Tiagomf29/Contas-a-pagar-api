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

import br.com.contasapi.domain.BankAccount;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.service.BankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/banks")
@Api(value = "Api Rest Conta de banco")
@CrossOrigin(origins = "*")
public class BankAccountController{

	@Autowired
	BankService bankService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os registros de conta de banco")
	public ArrayList<BankAccount> listAllBanks() {
		return bankService.allList();
	}

	@PostMapping
	@ApiOperation(value = "Insere um registro de conta de banco")	
	public ResponseEntity<BankAccount> insertBank(@Valid @RequestBody BankAccount t) {
		return ResponseEntity.ok((BankAccount) GenericsFunctions.returnObjectByMap(bankService.insert(t)));
	}

	@PutMapping
	@ApiOperation(value = "Atualiza um registro de conta de banco")
	public ResponseEntity<BankAccount> updateBank(@Valid @RequestBody BankAccount t) {
		
		BankAccount newPayer = (BankAccount) GenericsFunctions.returnObjectByMap(bankService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cod}")
	@ApiOperation(value = "Deleta um registro de conta de banco")
	public ResponseEntity<BankAccount> deleteBank(@PathVariable int cod) {
		return bankService.delete(cod); 
	}

	@GetMapping("/{cod}")
	@ApiOperation(value = "Lista um registro de conta de banco por código")
	public ArrayList<BankAccount> listConsultIdBank(@PathVariable int cod) {
		return bankService.listByCod(cod);
	}

}
