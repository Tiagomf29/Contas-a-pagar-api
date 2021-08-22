package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.Restore;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.RestoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/restore")
@Api(value = "Api Rest de registro de restore do banco de dados")
@CrossOrigin(origins = "*")
public class RestoreController implements InterfaceGenericsController<Restore>{

	@Autowired
	RestoreService restoreService;
	
	@Override
	@ApiOperation(value = "Lista todos os registros de restore de banco de dados")
	public ArrayList<Restore> listAllController() {
		return restoreService.allList();
	}

	@Override
	@ApiOperation(value = "Insere um novo registro de restore de banco de dados")
	public ResponseEntity<Restore> insertController(Restore t) {
		
		Restore restore = (Restore) GenericsFunctions.returnObjectByMap(restoreService.insert(t));
		
		if(restore.getCode() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(restore);
	}

	@Override
	@ApiOperation(value = "Atualiza um registro de restore de banco de dados")
	public ResponseEntity<Restore> updateController(Restore t) {
		
		Restore restore = (Restore) GenericsFunctions.returnObjectByMap(restoreService.insert(t));
		
		if(restore.getCode() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(restore);
	}

	@Override
	@ApiOperation(value = "Deleta um registro de restore de banco de dados")
	public ResponseEntity<Restore> deleteController(int cod) {
		return restoreService.delete(cod);
	}

	@Override
	@ApiOperation(value = "Consulta um registro de restore de banco de dados por código")
	public ArrayList<Restore> listConsultIdController(int id) {
		return restoreService.listByCod(id);
	}


}
