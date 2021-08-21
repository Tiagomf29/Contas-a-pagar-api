package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.AccountPayable;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.AccountPayableService;

@RestController
@RequestMapping("/accountPayable")
public class AccountPayableController implements InterfaceGenericsController<AccountPayable>{

	@Autowired
	AccountPayableService accountPayableService;	
	
	@Override
	public ArrayList<AccountPayable> listAllController() {
		return accountPayableService.allList();
	}

	@Override
	public ResponseEntity<AccountPayable> insertController(AccountPayable t) {
		return ResponseEntity.ok((AccountPayable) GenericsFunctions.returnObjectByMap(accountPayableService.insert(t)));
	}

	@Override
	public ResponseEntity<AccountPayable> updateController(AccountPayable t) {
		
		AccountPayable newPayer = (AccountPayable) GenericsFunctions.returnObjectByMap(accountPayableService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<AccountPayable> deleteController(int cod) {
		return accountPayableService.delete(cod); 
	}

	@Override
	public ArrayList<AccountPayable> listConsultIdController(int cod) {
		return accountPayableService.listByCod(cod);
	}

}
