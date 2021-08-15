package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.BankAccount;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankAccountController implements InterfaceGenericsController<BankAccount>{

	@Autowired
	BankService bankService;
	
	@Override
	public ArrayList<BankAccount> listAllController() {
		return bankService.allList();
	}

	@Override
	public ResponseEntity<BankAccount> insertController(BankAccount t) {
		return ResponseEntity.ok((BankAccount) GenericsFunctions.returnObjectByMap(bankService.insert(t)));
	}

	@Override
	public ResponseEntity<BankAccount> updateController(BankAccount t) {
		
		BankAccount newPayer = (BankAccount) GenericsFunctions.returnObjectByMap(bankService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<BankAccount> deleteController(int cod) {
		return bankService.delete(cod); 
	}

	@Override
	public ArrayList<BankAccount> listConsultIdController(int cod) {
		return bankService.listByCod(cod);
	}
	

	

}
