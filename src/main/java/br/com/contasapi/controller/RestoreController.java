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

import br.com.contasapi.domain.Restore;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.service.RestoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/restorations")
@Api(value = "Api Rest de registro de restore do banco de dados")
@CrossOrigin(origins = "*")
public class RestoreController{

	@Autowired
	RestoreService restoreService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os registros de restore de banco de dados")
	public ArrayList<Restore> listAllRestorations() {
		return restoreService.allList();
	}

	@PostMapping
	@ApiOperation(value = "Insere um novo registro de restore de banco de dados")
	public ResponseEntity<Restore> insertRestore(@Valid @RequestBody Restore t) {
		
		Restore restore = (Restore) GenericsFunctions.returnObjectByMap(restoreService.insert(t));
		
		if(restore.getCode() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(restore);
	}

	@PutMapping
	@ApiOperation(value = "Atualiza um registro de restore de banco de dados")
	public ResponseEntity<Restore> updateRestore(@Valid @RequestBody Restore t) {
		
		Restore restore = (Restore) GenericsFunctions.returnObjectByMap(restoreService.insert(t));
		
		if(restore.getCode() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(restore);
	}

	@DeleteMapping("/{cod}")
	@ApiOperation(value = "Deleta um registro de restore de banco de dados")
	public ResponseEntity<Restore> deleteRestore(@PathVariable int cod) {
		return restoreService.delete(cod);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Consulta um registro de restore de banco de dados por código")
	public ArrayList<Restore> listConsultIdRestore(@PathVariable int id) {
		return restoreService.listByCod(id);
	}

}
