package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.Payer;
import br.com.contasapi.service.PayerService;

@RestController
@RequestMapping("/Payer")
public class PayerController {
		
	@Autowired
	PayerService payerService;
	
	@GetMapping("/all")
	public ArrayList<Payer> listarTodos() {					
		return payerService.allListPayers();		
	}
		
	@PostMapping("/insert")
	public ResponseEntity<Payer> inserePayer(@RequestBody Payer payer) {		
		return payerService.insertPayer(payer);	
	}
  		
	@PostMapping("/update")
	public ResponseEntity<Payer> updatePayer(@RequestBody Payer payer) {		
		return payerService.updatePayer(payer);	
	}
	
	@DeleteMapping("/delete/{cod}")
	public ResponseEntity<Payer>deletePayer(@PathVariable int cod){				
		return payerService.deletePayer(cod); 
	}
	
}
