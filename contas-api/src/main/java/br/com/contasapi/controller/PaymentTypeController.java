package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.PaymentType;
import br.com.contasapi.genericsinterfaces.GenericsController;
import br.com.contasapi.service.PaymentTypeService;

@RestController
@RequestMapping("paymentType")
public class PaymentTypeController implements GenericsController<PaymentType>{

	@Autowired
	PaymentTypeService paymentTypeService;
	
	@Override
	public ArrayList<PaymentType> listAllController() {
		return paymentTypeService.allList();
	}

	@Override
	public ResponseEntity<PaymentType> insertController(PaymentType t) {
		return paymentTypeService.insert(t);
	}

	@Override
	public ResponseEntity<PaymentType> updateController(PaymentType t) {
		return paymentTypeService.update(t);
	}

	@Override
	public ResponseEntity<PaymentType> deleteController(int cod) {
		return paymentTypeService.delete(cod);
	}

}
