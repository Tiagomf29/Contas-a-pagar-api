package br.com.contasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.Restore;

public interface RestoreRepository extends JpaRepository<Restore, Integer>{
	List<Restore>findByPatchRestore(String name);
	List<Restore>findByCode(int cod);
}
