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

import br.com.contasapi.domain.Backup;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.service.BackupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("backups")
@Api(value = "Api Rest Backup")
@CrossOrigin(origins = "*")
public class BackupController {

	@Autowired
	BackupService backupService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os registros de backup de banco de dados")
	public ArrayList<Backup> listAllBackups() {
		return backupService.allList();
	}

	@PostMapping
	@ApiOperation(value = "Insere um registro de backup de banco de dados")
	public ResponseEntity<Backup> insertBackup(@Valid @RequestBody Backup t) {
		
		Backup backup = (Backup) GenericsFunctions.returnObjectByMap(backupService.insert(t));
		
		if(backup.getCode() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(backup);
	}

	@PutMapping
	@ApiOperation(value = "Atualiza um registro de backup de banco de dados")
	public ResponseEntity<Backup> updateBackup(@Valid @RequestBody Backup t) {
		Backup backup = (Backup) GenericsFunctions.returnObjectByMap(backupService.insert(t));
		
		if(backup.getCode() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(backup);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um registro de backup de banco de dados")
	public ResponseEntity<Backup> deleteBackup(@PathVariable int cod) {
		return backupService.delete(cod);
	}

	
	@GetMapping("/{id}")
	@ApiOperation(value = "Lista um registro de backup de banco de dados por código")
	public ArrayList<Backup> listConsultIdBackup(@PathVariable int id) {
		return backupService.listByCod(id);
	}

	
}
