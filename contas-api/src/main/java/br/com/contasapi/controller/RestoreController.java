package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.Restore;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.RestoreService;

@RestController
@RequestMapping("/restore")
public class RestoreController implements InterfaceGenericsController<Restore>{

	@Autowired
	RestoreService restoreService;
	
	@Override
	public ArrayList<Restore> listAllController() {
		return restoreService.allList();
	}

	@Override
	public ResponseEntity<Restore> insertController(Restore t) {
		
		Restore restore = (Restore) GenericsFunctions.returnObjectByMap(restoreService.insert(t));
		
		if(restore.getCode() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(restore);
	}

	@Override
	public ResponseEntity<Restore> updateController(Restore t) {
		
		Restore restore = (Restore) GenericsFunctions.returnObjectByMap(restoreService.insert(t));
		
		if(restore.getCode() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(restore);
	}

	@Override
	public ResponseEntity<Restore> deleteController(int cod) {
		return restoreService.delete(cod);
	}

	@Override
	public ArrayList<Restore> listConsultIdController(int id) {
		return restoreService.listByCod(id);
	}


}
