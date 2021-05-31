package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.Payer;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.GenericsController;
import br.com.contasapi.service.PayerService;

@RestController
@RequestMapping("/payer")
public class PayerController implements GenericsController<Payer>{
		
	@Autowired
	PayerService payerService;
	
	@Override
	public ArrayList<Payer> listAllController() {
		return payerService.allList();	
	}
	
	@Override
	public ResponseEntity<Payer> insertController(Payer t) {		
		return ResponseEntity.ok((Payer) GenericsFunctions.returnObjectByMap(payerService.insert(t)));
	}
	
	@Override
	public ResponseEntity<Payer> updateController(Payer t) {
		
		Payer newPayer = (Payer) GenericsFunctions.returnObjectByMap(payerService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@Override
	public ResponseEntity<Payer> deleteController(int cod) {
		return payerService.delete(cod); 
	}

	@Override
	public ArrayList<Payer> listConsultIdController(int cod) {
		return payerService.listByCod(cod);
	}

	
}
