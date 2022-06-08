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

import br.com.contasapi.domain.AccountPayable;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.service.AccountPayableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bills-to-pay")
@Api(value = "Api Rest Contas a pagar (Cabeçalho)")
@CrossOrigin(origins = "*")
public class AccountPayableController{

	@Autowired
	AccountPayableService accountPayableService;	
	
	@GetMapping
	@ApiOperation(value = "Lista todos os registros de cabeçalho de contas a pagar")
	public ArrayList<AccountPayable> listAllBillsToPay() {
		return accountPayableService.allList();
	}

	@PostMapping
	@ApiOperation(value = "Insere um registro de contas a pagar e seus respectivos lançamentos")	
	public ResponseEntity<AccountPayable> insertBillsToPay(@Valid @RequestBody AccountPayable accontPayable) {
		return ResponseEntity.ok((AccountPayable) GenericsFunctions.returnObjectByMap(accountPayableService.insert(accontPayable)));
	}

	@PutMapping
	@ApiOperation(value = "Atualiza o cabeçalho da conta a pagar")
	public ResponseEntity<AccountPayable> updateBillsToPay(@Valid @RequestBody AccountPayable accontPayable) {
		
		AccountPayable newPayer = (AccountPayable) GenericsFunctions.returnObjectByMap(accountPayableService.update(accontPayable));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cod}")
	@ApiOperation(value = "Deleta um registro de contas a pagar")
	public ResponseEntity<AccountPayable> deleteBillsToPay(@PathVariable int cod) {
		return accountPayableService.delete(cod); 
	}

	@GetMapping("/{cod}")
	@ApiOperation(value = "Lista um registro de contas a pagar por código")
	public ArrayList<AccountPayable> listConsultIdBillToPay(@PathVariable int cod) {
		return accountPayableService.listByCod(cod);
	}

}
