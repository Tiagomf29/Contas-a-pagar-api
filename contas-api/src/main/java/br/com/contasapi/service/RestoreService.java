package br.com.contasapi.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.Restore;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.GenericsCrud;
import br.com.contasapi.repository.RestoreRepository;

@Service
public class RestoreService implements GenericsCrud<Restore>{
	
	@Autowired
	RestoreRepository restoreRepository;

	@Override
	public HashMap<Restore, Integer> insert(Restore t) {
		HashMap<Restore, Integer>retorno = new HashMap<>();
		
		ArrayList<Restore>newBackup = (ArrayList<Restore>) restoreRepository.findAll();
		
		int codReturn= 0;
		
		if(newBackup.isEmpty()) {		
			codReturn = restoreRepository.save(t).getCode();
		}
		
		retorno.put(t, codReturn);
		return retorno;
	}
	
	@Override
	public HashMap<Restore, Integer> update(Restore t) {
					
		if (t.getCode() > 0) {
			return GenericsFunctions.returnMapByObjects(t, restoreRepository.save(t).getCode());
		}
		return GenericsFunctions.returnMapByObjects(t, 0);
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

	@Override
	public ArrayList<Restore> listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
