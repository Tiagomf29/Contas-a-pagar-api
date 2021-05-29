package br.com.contasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.Restore;

public interface RestoreRepository extends JpaRepository<Restore, Integer>{

}
