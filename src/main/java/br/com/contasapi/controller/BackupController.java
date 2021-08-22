package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.Backup;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.BackupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("backup")
@Api(value = "Api Rest Backup")
@CrossOrigin(origins = "*")
public class BackupController implements InterfaceGenericsController<Backup>{

	@Autowired
	BackupService backupService;
	
	@Override
	@ApiOperation(value = "Lista todos os registros de backup de banco de dados")
	public ArrayList<Backup> listAllController() {
		return backupService.allList();
	}

	@Override
	@ApiOperation(value = "Insere um registro de backup de banco de dados")
	public ResponseEntity<Backup> insertController(Backup t) {
		
		Backup backup = (Backup) GenericsFunctions.returnObjectByMap(backupService.insert(t));
		
		if(backup.getCode() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(backup);
	}

	@Override
	@ApiOperation(value = "Atualiza um registro de backup de banco de dados")
	public ResponseEntity<Backup> updateController(Backup t) {
		Backup backup = (Backup) GenericsFunctions.returnObjectByMap(backupService.insert(t));
		
		if(backup.getCode() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(backup);
	}

	@Override
	@ApiOperation(value = "Deleta um registro de backup de banco de dados")
	public ResponseEntity<Backup> deleteController(int cod) {
		return backupService.delete(cod);
	}

	@Override
	@ApiOperation(value = "Lista um registro de backup de banco de dados por código")
	public ArrayList<Backup> listConsultIdController(int id) {
		return backupService.listByCod(id);
	}

	
}
