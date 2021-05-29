package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.Restore;
import br.com.contasapi.genericsinterfaces.GenericsController;
import br.com.contasapi.service.RestoreService;

@RestController
@RequestMapping("/restore")
public class RestoreController implements GenericsController<Restore>{

	@Autowired
	RestoreService restoreService;
	
	@Override
	public ArrayList<Restore> listAllController() {
		return restoreService.allList();
	}

	@Override
	public ResponseEntity<Restore> insertController(Restore t) {
		return restoreService.insert(t);
	}

	@Override
	public ResponseEntity<Restore> updateController(Restore t) {
		return restoreService.update(t);
	}

	@Override
	public ResponseEntity<Restore> deleteController(int cod) {
		return restoreService.delete(cod);
	}

}
