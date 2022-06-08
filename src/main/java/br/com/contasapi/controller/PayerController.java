package br.com.contasapi.controller;

import java.sql.SQLException;
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

import br.com.contasapi.domain.Payer;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.repository.PayerRespository;
import br.com.contasapi.service.PayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/payers")
@Api(value = "Api Rest Pagadores")
@CrossOrigin(origins = "*")
public class PayerController{
		
	@Autowired
	PayerService payerService;
	
	@Autowired
	PayerRespository payerRepository;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os registros de pagadores")
	public ArrayList<Payer> listAllPayers() {
		return payerService.allList();	
	}
	
	
	@ApiOperation(value = "Insere um novo registro de pagador")
	@PostMapping
	public ResponseEntity<Payer> insertPayer(@Valid @RequestBody Payer t) {		
		return ResponseEntity.ok((Payer) GenericsFunctions.returnObjectByMap(payerService.insert(t)));
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza um registro de pagador")
	public ResponseEntity<Payer> updatePayer(@Valid @RequestBody Payer t) {
		
		Payer newPayer = (Payer) GenericsFunctions.returnObjectByMap(payerService.update(t));
		
		if(newPayer.getCode() != 0) {
			return ResponseEntity.ok(newPayer);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cod}")
	@ApiOperation(value = "Deleta um registro de pagador")
	public ResponseEntity<Payer> deletePayer(@PathVariable int cod) {
		return payerService.delete(cod); 
	}

	@GetMapping("/{cod}")
	@ApiOperation(value = "Consulta um registro de pagador por código")
	public ArrayList<Payer> listConsultIdController(@PathVariable int cod) {
		return payerService.listByCod(cod);
	}
	
	@GetMapping("teste")
	public ArrayList<Payer> listaTeste() throws SQLException{
		
		return (ArrayList<Payer>) payerRepository.listaPayer();
	}

	
}
