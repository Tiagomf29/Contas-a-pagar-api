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

import br.com.contasapi.domain.PaymentType;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.service.PaymentTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("paymentTypes")
@Api(value = "Api Rest de tipo de pagamentos")
@CrossOrigin(origins = "*")
public class PaymentTypeController{

	@Autowired
	PaymentTypeService paymentTypeService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os registros de tipo de pagamento")
	public ArrayList<PaymentType> listAllPaymentTypes() {
		return paymentTypeService.allList();
	}

	@PostMapping
	@ApiOperation(value = "Insere um novo registro de tipo de pagamento")
	public ResponseEntity<PaymentType> insertPaymentType(@Valid @RequestBody PaymentType t) {
		return ResponseEntity.ok((PaymentType) GenericsFunctions.returnObjectByMap(paymentTypeService.insert(t)));
	}

	@PutMapping
	@ApiOperation(value = "Atualiza um registro de tipo de pagamento")
	public ResponseEntity<PaymentType> updatePaymentType(@Valid@RequestBody PaymentType t) {
		
		PaymentType newPaymentType = (PaymentType) GenericsFunctions.returnObjectByMap(paymentTypeService.update(t));
		
		if(newPaymentType.getCode() != 0) {
			return ResponseEntity.ok(newPaymentType);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cod}")
	@ApiOperation(value = "Deleta um registro de tipo de pagamento")
	public ResponseEntity<PaymentType> deletePaymentType(@PathVariable int cod) {
		return paymentTypeService.delete(cod);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Consulta um registro de tipo de pagamento por código")
	public ArrayList<PaymentType> listConsultIdPaymentType(@PathVariable int id) {
		return paymentTypeService.listByCod(id);
	}



}
