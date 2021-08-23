package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.Payer;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.PayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/payer")
@Api(value = "Api Rest Pagadores")
@CrossOrigin(origins = "*")
public class PayerController implements InterfaceGenericsController<Payer>{
		
	@Autowired
	PayerService payerService;
	
	@Override
	@ApiOperation(value = "Lista todos os registros de pagadores")
	public ArrayList<Payer> listAllController() {
		return payerService.allList();	
	}
	
	
	@ApiOperation(value = "Insere um novo registro de pagador")
	@Override
	public ResponseEntity<Payer> insertController(Payer t) {		
		return ResponseEntity.ok((Payer) GenericsFunctions.returnObjectByMap(payerService.insert(t)));
	}
	
	@Override
	@ApiOperation(value = "Atualiza um registro de pagador")
	public ResponseEntity<Payer> updateController(Payer t) {
		
		Payer newPayer = (Payer) GenericsFunctions.returnObjectByMap(payerService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@Override
	@ApiOperation(value = "Deleta um registro de pagador")
	public ResponseEntity<Payer> deleteController(int cod) {
		return payerService.delete(cod); 
	}

	@Override
	@ApiOperation(value = "Consulta um registro de pagador por código")
	public ArrayList<Payer> listConsultIdController(int cod) {
		return payerService.listByCod(cod);
	}

	
}
