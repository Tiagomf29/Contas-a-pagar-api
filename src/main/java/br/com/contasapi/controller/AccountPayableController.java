package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.AccountPayable;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.AccountPayableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/accountPayable")
@Api(value = "Api Rest Contas a pagar (Cabeçalho)")
@CrossOrigin(origins = "*")
public class AccountPayableController implements InterfaceGenericsController<AccountPayable>{

	@Autowired
	AccountPayableService accountPayableService;	
	
	@Override
	@ApiOperation(value = "Lista todos os registros de cabeçalho de contas a pagar")
	public ArrayList<AccountPayable> listAllController() {
		return accountPayableService.allList();
	}

	@Override
	@ApiOperation(value = "Insere um registro de contas a pagar e seus respectivos lançamentos")	
	public ResponseEntity<AccountPayable> insertController(AccountPayable t) {
		return ResponseEntity.ok((AccountPayable) GenericsFunctions.returnObjectByMap(accountPayableService.insert(t)));
	}

	@Override
	@ApiOperation(value = "Atualiza o cabeçalho da conta a pagar")
	public ResponseEntity<AccountPayable> updateController(AccountPayable t) {
		
		AccountPayable newPayer = (AccountPayable) GenericsFunctions.returnObjectByMap(accountPayableService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	@ApiOperation(value = "Deleta um registro de contas a pagar")
	public ResponseEntity<AccountPayable> deleteController(int cod) {
		return accountPayableService.delete(cod); 
	}

	@Override
	@ApiOperation(value = "Lista um registro de contas a pagar por código")
	public ArrayList<AccountPayable> listConsultIdController(int cod) {
		return accountPayableService.listByCod(cod);
	}

}
