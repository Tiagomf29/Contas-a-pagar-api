package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.BankAccount;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.BankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bank")
@Api(value = "Api Rest Conta de banco")
@CrossOrigin(origins = "*")
public class BankAccountController implements InterfaceGenericsController<BankAccount>{

	@Autowired
	BankService bankService;
	
	@Override
	@ApiOperation(value = "Lista todos os registros de conta de banco")
	public ArrayList<BankAccount> listAllController() {
		return bankService.allList();
	}

	@Override
	@ApiOperation(value = "Insere um registro de conta de banco")	
	public ResponseEntity<BankAccount> insertController(BankAccount t) {
		return ResponseEntity.ok((BankAccount) GenericsFunctions.returnObjectByMap(bankService.insert(t)));
	}

	@Override
	@ApiOperation(value = "Atualiza um registro de conta de banco")
	public ResponseEntity<BankAccount> updateController(BankAccount t) {
		
		BankAccount newPayer = (BankAccount) GenericsFunctions.returnObjectByMap(bankService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	@ApiOperation(value = "Deleta um registro de conta de banco")
	public ResponseEntity<BankAccount> deleteController(int cod) {
		return bankService.delete(cod); 
	}

	@Override
	@ApiOperation(value = "Lista um resgitro de conta de banco por código")
	public ArrayList<BankAccount> listConsultIdController(int cod) {
		return bankService.listByCod(cod);
	}
	

	

}
