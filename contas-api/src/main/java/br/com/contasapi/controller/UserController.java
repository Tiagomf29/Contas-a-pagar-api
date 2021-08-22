package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.User;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceUserController;
import br.com.contasapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value = "Api Rest de usuários")
@CrossOrigin(origins = "*")
public class UserController implements InterfaceUserController<User>{

	@Autowired
	UserService userService;
	
	@Override
	@ApiOperation(value = "Lista todos os registros de usuário")
	public ArrayList<User> listAllController() {
		return userService.allList();
	}

	@Override
	@ApiOperation(value = "Insere um novo registro de usuário")
	public ResponseEntity<User> insertController(User t) {
		return ResponseEntity.ok((User) GenericsFunctions.returnObjectByMap(userService.insert(t)));
	}

	@Override
	@ApiOperation(value = "Atualiza um registro de usuário")
	public ResponseEntity<User> updateController(User t) {
		User newUser = (User) GenericsFunctions.returnObjectByMap(userService.update(t));
		
		if(newUser.getCode() != 0) {
			return ResponseEntity.ok(newUser);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	@ApiOperation(value = "Deleta um registro de usuário")
	public ResponseEntity<User> deleteController(int cod) {
		return userService.delete(cod); 
	}

	@Override
	@ApiOperation(value = "Consulta um registro de usuário por código")
	public ArrayList<User> listConsultIdController(int cod) {
		return userService.listByCod(cod);
	}
	
	@Override
	@ApiOperation(value = "Valida entrada do usuário no sistema")
	public Boolean loginOk(User t) {				 		
		return userService.validaLogin(t);
	}
	

}
