package br.com.contasapi.genericsinterfaces;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface InterfaceUserController<T> {

	@GetMapping("/all")
	ArrayList<T> listAllController ();
	@PostMapping("/insert")
	ResponseEntity<T> insertController  (@Valid @RequestBody T t);
	@PutMapping("/update")
	ResponseEntity <T> updateController  (@Valid @RequestBody T t);
	@DeleteMapping("/delete/{cod}")
	ResponseEntity <T> deleteController  (@PathVariable int cod);
	@GetMapping("/consultId/{cod}")
	ArrayList<T> listConsultIdController (@PathVariable int cod);
	@GetMapping("/login")
	Boolean loginOk(@RequestBody T t);
		
}
