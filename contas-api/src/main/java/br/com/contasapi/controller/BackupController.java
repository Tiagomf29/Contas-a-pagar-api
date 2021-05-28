package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.Backup;
import br.com.contasapi.genericsinterfaces.GenericsController;
import br.com.contasapi.service.BackupService;

@RestController
@RequestMapping("backup")
public class BackupController implements GenericsController<Backup>{

	@Autowired
	BackupService backupService;
	
	@Override
	public ArrayList<Backup> listAllController() {
		return backupService.allList();
	}

	@Override
	public ResponseEntity<Backup> insertController(Backup t) {
		return backupService.insert(t);
	}

	@Override
	public ResponseEntity<Backup> updateController(Backup t) {
		return backupService.update(t);
	}

	@Override
	public ResponseEntity<Backup> deleteController(int cod) {
		return backupService.delete(cod);
	}
	
}
