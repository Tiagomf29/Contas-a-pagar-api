package br.com.contasapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		Optional<List<Backup>> newBackup = Optional.ofNullable(backupRepository.findAll());
		
		if(newBackup.equals("[ ]")) {		
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
