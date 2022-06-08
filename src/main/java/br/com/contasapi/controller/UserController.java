package br.com.contasapi.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.User;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
@Api(value = "Api Rest de usuários")
@CrossOrigin("*")
public class UserController{

	@Autowired
	UserService userService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os registros de usuário")
	public ArrayList<User> listAllUsers() {
		return userService.allList();
	}

	@PostMapping
	@ApiOperation(value = "Insere um novo registro de usuário")
	public ResponseEntity<User> insertUser(@Valid @RequestBody User t) {
		return ResponseEntity.ok((User) GenericsFunctions.returnObjectByMap(userService.insert(t)));
	}

	@PutMapping
	@ApiOperation(value = "Atualiza um registro de usuário")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User t) {
		User newUser = (User) GenericsFunctions.returnObjectByMap(userService.update(t));
		
		if(newUser.getCode() != 0) {
			return ResponseEntity.ok(newUser);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cod}")
	@ApiOperation(value = "Deleta um registro de usuário")
	public ResponseEntity<User> deleteUser(@PathVariable int cod) {
		return userService.delete(cod); 
	}

	@GetMapping("/{cod}")
	@ApiOperation(value = "Consulta um registro de usuário por código")
	public ArrayList<User> listConsultIdUser(@PathVariable int cod) {
		return userService.listByCod(cod);
	}
	
	@GetMapping("/{user}/{password}")
	@ApiOperation(value = "Valida entrada do usuário no sistema")
	public Boolean loginOk(@PathVariable String user, @PathVariable String password) {	
		User oUser = new User();
		oUser.setLogin(user);
		oUser.setPassword(password);
		
		return userService.validaLogin(oUser);
	}
	

}
