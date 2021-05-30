package br.com.contasapi.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.Backup;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.GenericsCrud;
import br.com.contasapi.repository.BackupRepository;

@Service
public class BackupService implements GenericsCrud<Backup> {
	
	@Autowired
	BackupRepository backupRepository;
	
	@Override
	public HashMap<Backup, Integer> insert(Backup t) {
		HashMap<Backup, Integer>retorno = new HashMap<>();
		
		ArrayList<Backup>newBackup = (ArrayList<Backup>) backupRepository.findAll();
		
		int codReturn= 0;
		
		if(newBackup.isEmpty()) {		
			codReturn = backupRepository.save(t).getCode();
		}
		
		retorno.put(t, codReturn);
		return retorno;
	}
	
	@Override
	public HashMap<Backup, Integer> update(Backup t) {
		if (t.getCode() > 0) {
			return GenericsFunctions.returnMapByObjects(t, backupRepository.save(t).getCode());
		}
		return GenericsFunctions.returnMapByObjects(t, 0);
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

	@Override
	public ArrayList<Backup> listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
