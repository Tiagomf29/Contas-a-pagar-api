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

import br.com.contasapi.domain.Backup;
import br.com.contasapi.repository.BackupRepository;
import br.com.contasapi.service.BackupService;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BackupTests {
	
	@Autowired
	BackupService backupService;
	@Autowired
	BackupRepository backupRepository;	
	
	@Test
	public void deletePayerRepository() {
		
		Backup backup = new Backup();		
		backup.setPatchBackup("C:\teste");
		
		int idGerado = 0;
		
		HashMap<Backup, Integer> newBackup = backupService.insert(backup);
		for(Map.Entry<Backup, Integer> value : newBackup.entrySet()) {
			idGerado = value.getValue();
		}	
		
		backupRepository.deleteById(idGerado);
		
		ArrayList<Backup> backup2 = new ArrayList<>();
		
		backup2 = backupService.listByCod(idGerado);
		
		Assertions.assertEquals(0, backup2.size());;					
				
	}
	
	@Test
	public void updatePayerRepository() {
		
		Backup backup = new Backup();		
		backup.setPatchBackup("c:\teste");
		
		int idGerado = 0;
		
		HashMap<Backup, Integer> newBackup = backupService.insert(backup);
		for(Map.Entry<Backup, Integer> value : newBackup.entrySet()) {
			idGerado = value.getValue();
		}		
		
		Backup backup2 = new Backup();
		backup2.setCode(idGerado);
		backup2.setPatchBackup("c:\\teste\\outroTeste");
		
		backupService.update(backup2);
		
		List<Backup> listBackup = new ArrayList<>();
		listBackup = backupRepository.findByPatchBackup("c:\\teste\\outroTeste");
		
		Assertions.assertEquals(true,!listBackup.isEmpty());		
	} 	
	
	@Test
	public void insertPayerRepository() {
		
		Backup backup = new Backup();		
		backup.setPatchBackup("c:\\teste10");
		
		int idGerado = 0;
		
		HashMap<Backup, Integer> newBackup = backupService.insert(backup);
		for(Map.Entry<Backup, Integer> value : newBackup.entrySet()) {
			idGerado = value.getValue();
		}
								
		Optional<List<Backup>> list = Optional.ofNullable(backupService.listByCod(idGerado));
		
		Assertions.assertEquals(true,list.isPresent());				
	}
   
   
   @Test
   public void tearDown() {
	   
	   backupRepository.deleteAll();
   }


}
