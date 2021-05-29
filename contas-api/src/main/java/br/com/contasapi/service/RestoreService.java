package br.com.contasapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.Restore;
import br.com.contasapi.genericsinterfaces.GenericsCrud;
import br.com.contasapi.repository.RestoreRepository;

@Service
public class RestoreService implements GenericsCrud<Restore>{
	
	@Autowired
	RestoreRepository restoreRepository;

	@Override
	public ResponseEntity<Restore> insert(Restore t) {
		ArrayList<Restore>newBackup = (ArrayList<Restore>) restoreRepository.findAll();
		
		if(newBackup.isEmpty()) {		
			return ResponseEntity.ok(restoreRepository.save(t));
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Restore> update(Restore t) {
		if (t.getCode() > 0) {
			return ResponseEntity.ok(restoreRepository.save(t));
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Restore> delete(int id) {
		restoreRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ArrayList<Restore> allList() {
		return (ArrayList<Restore>) restoreRepository.findAll();
	}

}
