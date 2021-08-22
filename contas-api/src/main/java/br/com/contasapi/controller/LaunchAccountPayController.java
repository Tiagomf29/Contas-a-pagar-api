package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.LaunchAccountPay;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.LaunchAccountPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/launchAccountPay")
@Api(value = "Api Rest lançamentos de contas a pagar")
@CrossOrigin(origins = "*")
public class LaunchAccountPayController implements InterfaceGenericsController<LaunchAccountPay>{

	@Autowired
	LaunchAccountPayService launchAccountPayService;
	
	@Override
	@ApiOperation(value = "Lista todos os registros de lançamentos de contas a pagar")
	public ArrayList<LaunchAccountPay> listAllController() {
		return launchAccountPayService.allList();
	}

	@Override
	@ApiOperation(value = "Insere um registro de lançamento de contas a pagar")	
	public ResponseEntity<LaunchAccountPay> insertController(LaunchAccountPay t) {
		return ResponseEntity.ok((LaunchAccountPay) GenericsFunctions.returnObjectByMap(launchAccountPayService.insert(t)));
	}

	@Override
	@ApiOperation(value = "Atualiza um registro de lançamento de contas a pagar")
	public ResponseEntity<LaunchAccountPay> updateController(LaunchAccountPay t) {
		
		LaunchAccountPay newPayer = (LaunchAccountPay) GenericsFunctions.returnObjectByMap(launchAccountPayService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	@ApiOperation(value = "Deleta um registro de lançamento de contas a pagar")
	public ResponseEntity<LaunchAccountPay> deleteController(int cod) {
		return launchAccountPayService.delete(cod); 
	}

	@Override
	@ApiOperation(value = "Lista um registro de lançamento de contas a pagar por código")
	public ArrayList<LaunchAccountPay> listConsultIdController(int cod) {
		return launchAccountPayService.listByCod(cod);
	}

}
