package br.com.contasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contasapi.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	List<User>findByLogin(String login);
	List<User>findByCode(int cod);
	User findByLoginAndPassword(String login, String password);
	
}
