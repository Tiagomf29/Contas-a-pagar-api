package br.com.contasapi.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.contasapi.domain.Restore;
import br.com.contasapi.repository.RestoreRepository;
import br.com.contasapi.service.RestoreService;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestoreTests {
	@Autowired
	RestoreService restoreService;
	@Autowired
	RestoreRepository restoreRepository;	
	
	@Test
	public void deletePayerRepository() {
		
		Restore restore = new Restore();		
		restore.setPatchRestore("C:\teste");
		
		int idGerado = 0;
		
		HashMap<Restore, Integer> newRestore = restoreService.insert(restore);
		for(Map.Entry<Restore, Integer> value : newRestore.entrySet()) {
			idGerado = value.getValue();
		}	
		
		restoreRepository.deleteById(idGerado);
		
		ArrayList<Restore> restore2 = new ArrayList<>();
		
		restore2 = restoreService.listByCod(idGerado);
		
		Assertions.assertEquals(0, restore2.size());;					
				
	}
	
	@Test
	public void updatePayerRepository() {
		
		Restore restore = new Restore();		
		restore.setPatchRestore("C:\teste");
		
		int idGerado = 0;
		
		HashMap<Restore, Integer> newRestore = restoreService.insert(restore);
		for(Map.Entry<Restore, Integer> value : newRestore.entrySet()) {
			idGerado = value.getValue();
		}		
		
		Restore restore2 = new Restore();
		restore2.setCode(idGerado);
		restore2.setPatchRestore("c:\\teste\\outroTeste");
		
		restoreService.update(restore2);
		
		List<Restore> listRestore = new ArrayList<>();
		listRestore = restoreRepository.findByPatchRestore("c:\\teste\\outroTeste");
		
		Assertions.assertEquals(true,!listRestore.isEmpty());		
	} 	
	
	@Test
	public void insertPayerRepository() {
		
		Restore restore = new Restore();		
		restore.setPatchRestore("c:\\teste10");
		
		int idGerado = 0;
		
		HashMap<Restore, Integer> newRestore = restoreService.insert(restore);
		for(Map.Entry<Restore, Integer> value : newRestore.entrySet()) {
			idGerado = value.getValue();
		}
								
		Optional<List<Restore>> list = Optional.ofNullable(restoreService.listByCod(idGerado));
		
		Assertions.assertEquals(true,list.isPresent());				
	}
   
   
   @Test
   public void tearDown() {
	   
	   restoreRepository.deleteAll();
   }
}
