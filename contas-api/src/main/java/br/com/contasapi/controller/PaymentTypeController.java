package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.PaymentType;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.PaymentTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("paymentType")
@Api(value = "Api Rest de tipo de pagamentos")
@CrossOrigin(origins = "*")
public class PaymentTypeController implements InterfaceGenericsController<PaymentType>{

	@Autowired
	PaymentTypeService paymentTypeService;
	
	@Override
	@ApiOperation(value = "Lista todos os registros de tipo de pagamento")
	public ArrayList<PaymentType> listAllController() {
		return paymentTypeService.allList();
	}

	@Override
	@ApiOperation(value = "Insere um novo registro de tipo de pagamento")
	public ResponseEntity<PaymentType> insertController(PaymentType t) {
		return ResponseEntity.ok((PaymentType) GenericsFunctions.returnObjectByMap(paymentTypeService.insert(t)));
	}

	@Override
	@ApiOperation(value = "Atualiza um registro de tipo de pagamento")
	public ResponseEntity<PaymentType> updateController(PaymentType t) {
		
		PaymentType newPaymentType = (PaymentType) GenericsFunctions.returnObjectByMap(paymentTypeService.update(t));
		
		if(newPaymentType.getCode() != 0) {
			return ResponseEntity.ok(newPaymentType);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	@ApiOperation(value = "Deleta um registro de tipo de pagamento")
	public ResponseEntity<PaymentType> deleteController(int cod) {
		return paymentTypeService.delete(cod);
	}

	@Override
	@ApiOperation(value = "Consulta um registro de tipo de pagamento por código")
	public ArrayList<PaymentType> listConsultIdController(int id) {
		return paymentTypeService.listByCod(id);
	}



}
