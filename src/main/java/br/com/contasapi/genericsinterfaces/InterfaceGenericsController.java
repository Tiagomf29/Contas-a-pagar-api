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

public interface InterfaceGenericsController<T> {
	
	@GetMapping
	public ArrayList<T> listAllController ();
	@PostMapping
	public ResponseEntity<T> insertController  (@Valid @RequestBody T t);
	@PutMapping
	public ResponseEntity <T> updateController  (@Valid @RequestBody T t);
	@DeleteMapping("/{cod}")
	public ResponseEntity <T> deleteController  (@PathVariable int cod);
	@GetMapping("/{cod}")
	public ArrayList<T> listConsultIdController(@PathVariable int cod);
	
}
