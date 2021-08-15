package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.User;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceUserController;
import br.com.contasapi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController implements InterfaceUserController<User>{

	@Autowired
	UserService userService;
	
	@Override
	public ArrayList<User> listAllController() {
		return userService.allList();
	}

	@Override
	public ResponseEntity<User> insertController(User t) {
		return ResponseEntity.ok((User) GenericsFunctions.returnObjectByMap(userService.insert(t)));
	}

	@Override
	public ResponseEntity<User> updateController(User t) {
		User newUser = (User) GenericsFunctions.returnObjectByMap(userService.update(t));
		
		if(newUser.getCode() != 0) {
			return ResponseEntity.ok(newUser);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<User> deleteController(int cod) {
		return userService.delete(cod); 
	}

	@Override
	public ArrayList<User> listConsultIdController(int cod) {
		return userService.listByCod(cod);
	}
	
	@Override
	public Boolean loginOk(User t) {				 		
		return userService.validaLogin(t);
	}
	

}
