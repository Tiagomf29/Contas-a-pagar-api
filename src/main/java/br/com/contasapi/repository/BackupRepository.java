package br.com.contasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.Backup;

public interface BackupRepository extends JpaRepository<Backup, Integer>{
	List<Backup>findByPatchBackup(String name);
	List<Backup>findByCode(int cod);	
}
