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

import br.com.contasapi.domain.User;
import br.com.contasapi.repository.UserRepository;
import br.com.contasapi.service.UserService;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTests {
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;	
	
	@Test
	public void deletePayerRepository() {
		
		User user = new User();		
		user.setLogin("Teste Delete");
		user.setCpf("07008488855");
		user.setFullName("Teste nome completo");
		user.setPassword("123");
		
		int idGerado = 0;
		
		HashMap<User, Integer> newUser = userService.insert(user);
		for(Map.Entry<User, Integer> value : newUser.entrySet()) {
			idGerado = value.getValue();
		}	
		
		userRepository.deleteById(idGerado);
		
		ArrayList<User> user2 = new ArrayList<>();
		
		user2 = userService.listByCod(idGerado);
		
		Assertions.assertEquals(0, user2.size());					
				
	}
	
	@Test
	public void updatePayerRepository() {
		
		User user = new User();		
		user.setLogin("Teste Salvar");
		user.setFullName("Teste Salvar");
		user.setCpf("07008488855");
		user.setPassword("123");
		
		int idGerado = 0;
		
		HashMap<User, Integer> newUser = userService.insert(user);
		for(Map.Entry<User, Integer> value : newUser.entrySet()) {
			idGerado = value.getValue();
		}		
		
		User user2 = new User();
		user2.setCode(idGerado);
		user2.setFullName("Teste nome completo");
		user2.setCpf("07008488855");
		user2.setLogin("Teste Atualizar");
		
		userService.update(user2);
		
		List<User> listUser = new ArrayList<>();
		listUser = userRepository.findByLogin("Teste Atualizar");
		
		Assertions.assertEquals(true,!listUser.isEmpty());		
	} 	
	
	@Test
	public void insertPayerRepository() {
		
		User user = new User();		
		user.setLogin("Teste Salvar");
		user.setFullName("Teste nome completo Salvar");
		user.setCpf("07008488855");
		user.setPassword("123");
		
		int idGerado = 0;
		
		HashMap<User, Integer> newPayer = userService.insert(user);
		for(Map.Entry<User, Integer> value : newPayer.entrySet()) {
			idGerado = value.getValue();
		}
								
		Optional<List<User>> list = Optional.ofNullable(userService.listByCod(idGerado));
		
		Assertions.assertEquals(true,list.isPresent());				
	}
   
   
   @Test
   public void tearDown() {
	   
	   userRepository.deleteAll();
   }
}
