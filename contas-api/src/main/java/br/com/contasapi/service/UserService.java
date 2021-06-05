package br.com.contasapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.User;
import br.com.contasapi.functions.utils.CriptografiaMD5;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceCrudUser;
import br.com.contasapi.repository.UserRepository;

@Service
public class UserService implements InterfaceCrudUser<User>{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public HashMap<User, Integer> insert(User t) {		
		t.setPassword(CriptografiaMD5.CriptografaSenha(t.getPassword()));		
		return GenericsFunctions.returnMapByObjects(t, userRepository.save(t).getCode());
	}

	@Override
	public HashMap<User, Integer> update(User t) {
		if(t.getCode() > 0) {	
			
			return GenericsFunctions.returnMapByObjects(t, userRepository.save(t).getCode());			
		}
	  
		return GenericsFunctions.returnMapByObjects(t, 0);
	}

	@Override
	public ResponseEntity<User> delete(int id) {
		userRepository.deleteById(id);		
		return ResponseEntity.noContent().build();
	}

	@Override
	public ArrayList<User> allList() {
		return (ArrayList<User>) userRepository.findAll();
	}

	@Override
	public ArrayList<User> listByCod(int id) {
		// TODO Auto-generated method stub
		return (ArrayList<User>) userRepository.findByCode(id);
	}

	@Override
	public Boolean validaLogin(String login, String password) {
		
		Optional<User> userLogin =  Optional.ofNullable(userRepository.findByLoginAndPassword(login, CriptografiaMD5.CriptografaSenha(password)));
		return userLogin.isPresent();
	}	

}
