package br.com.contasapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.Backup;
import br.com.contasapi.genericsinterfaces.GenericsCrud;
import br.com.contasapi.repository.BackupRepository;

@Service
public class BackupService implements GenericsCrud<Backup> {
	
	@Autowired
	BackupRepository backupRepository;
	
	@Override
	public ResponseEntity<Backup> insert(Backup t) {
		
		ArrayList<Backup>newBackup = (ArrayList<Backup>) backupRepository.findAll();
		
		if(newBackup.isEmpty()) {		
			return ResponseEntity.ok(backupRepository.save(t));
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Backup> update(Backup t) {
		
		if (t.getCode() > 0) {
			return ResponseEntity.ok(backupRepository.save(t));
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Backup> delete(int id) {
		backupRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ArrayList<Backup> allList() {
		return (ArrayList<Backup>) backupRepository.findAll();
	}


}
