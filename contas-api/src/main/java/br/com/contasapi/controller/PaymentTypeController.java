package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.PaymentType;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.PaymentTypeService;

@RestController
@RequestMapping("paymentType")
public class PaymentTypeController implements InterfaceGenericsController<PaymentType>{

	@Autowired
	PaymentTypeService paymentTypeService;
	
	@Override
	public ArrayList<PaymentType> listAllController() {
		return paymentTypeService.allList();
	}

	@Override
	public ResponseEntity<PaymentType> insertController(PaymentType t) {
		return ResponseEntity.ok((PaymentType) GenericsFunctions.returnObjectByMap(paymentTypeService.insert(t)));
	}

	@Override
	public ResponseEntity<PaymentType> updateController(PaymentType t) {
		
		PaymentType newPaymentType = (PaymentType) GenericsFunctions.returnObjectByMap(paymentTypeService.update(t));
		
		if(newPaymentType.getCode() != 0) {
			return ResponseEntity.ok(newPaymentType);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<PaymentType> deleteController(int cod) {
		return paymentTypeService.delete(cod);
	}

	@Override
	public ArrayList<PaymentType> listConsultIdController(int id) {
		return paymentTypeService.listByCod(id);
	}



}
