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

import br.com.contasapi.domain.LaunchAccountPay;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.service.LaunchAccountPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/accounts-payable-postings")
@Api(value = "Api Rest lançamentos de contas a pagar")
@CrossOrigin(origins = "*")
public class LaunchAccountPayController{

	@Autowired
	LaunchAccountPayService launchAccountPayService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os registros de lançamentos de contas a pagar")
	public ArrayList<LaunchAccountPay> listAllPostings() {
		return launchAccountPayService.allList();
	}

	@PostMapping
	@ApiOperation(value = "Insere um registro de lançamento de contas a pagar")	
	public ResponseEntity<LaunchAccountPay> insertPosting(@Valid @RequestBody LaunchAccountPay t) {
		return ResponseEntity.ok((LaunchAccountPay) GenericsFunctions.returnObjectByMap(launchAccountPayService.insert(t)));
	}

	@PutMapping
	@ApiOperation(value = "Atualiza um registro de lançamento de contas a pagar")
	public ResponseEntity<LaunchAccountPay> updatePosting(@Valid @RequestBody LaunchAccountPay t) {
		
		LaunchAccountPay newPayer = (LaunchAccountPay) GenericsFunctions.returnObjectByMap(launchAccountPayService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cod}")
	@ApiOperation(value = "Deleta um registro de lançamento de contas a pagar")
	public ResponseEntity<LaunchAccountPay> deletePosting(@PathVariable int cod) {
		return launchAccountPayService.delete(cod); 
	}

	@GetMapping("/{cod}")
	@ApiOperation(value = "Lista um registro de lançamento de contas a pagar por código")
	public ArrayList<LaunchAccountPay> listConsultIdPosting(@PathVariable int cod) {
		return launchAccountPayService.listByCod(cod);
	}

}
