package br.com.contasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.Backup;

public interface BackupRepository extends JpaRepository<Backup, Integer>{

}
