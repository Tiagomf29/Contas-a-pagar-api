package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.LaunchAccountPay;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.LaunchAccountPayService;

@RestController
@RequestMapping("/launchAccountPay")
public class LaunchAccountPayController implements InterfaceGenericsController<LaunchAccountPay>{

	@Autowired
	LaunchAccountPayService launchAccountPayService;
	
	@Override
	public ArrayList<LaunchAccountPay> listAllController() {
		return launchAccountPayService.allList();
	}

	@Override
	public ResponseEntity<LaunchAccountPay> insertController(LaunchAccountPay t) {
		return ResponseEntity.ok((LaunchAccountPay) GenericsFunctions.returnObjectByMap(launchAccountPayService.insert(t)));
	}

	@Override
	public ResponseEntity<LaunchAccountPay> updateController(LaunchAccountPay t) {
		
		LaunchAccountPay newPayer = (LaunchAccountPay) GenericsFunctions.returnObjectByMap(launchAccountPayService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<LaunchAccountPay> deleteController(int cod) {
		return launchAccountPayService.delete(cod); 
	}

	@Override
	public ArrayList<LaunchAccountPay> listConsultIdController(int cod) {
		return launchAccountPayService.listByCod(cod);
	}

}
