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

import br.com.contasapi.domain.TypeIncome;
import br.com.contasapi.repository.TypeIncomeRepository;
import br.com.contasapi.service.TypeIncomeService;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TypeIncomeTests {
	
	@Autowired
	TypeIncomeService typeIncomeService;
	@Autowired
	TypeIncomeRepository typeIncomeRepository;	
	
	@Test
	public void deletePayerRepository() {
		
		TypeIncome typeIncome = new TypeIncome();		
		typeIncome.setDescription("Teste Delete");
		
		int idGerado = 0;
		
		HashMap<TypeIncome, Integer> newTypeIncome = typeIncomeService.insert(typeIncome);
		for(Map.Entry<TypeIncome, Integer> value : newTypeIncome.entrySet()) {
			idGerado = value.getValue();
		}	
		
		typeIncomeRepository.deleteById(idGerado);
		
		ArrayList<TypeIncome> typeIncome2 = new ArrayList<>();
		
		typeIncome2 = typeIncomeService.listByCod(idGerado);
		
		Assertions.assertEquals(0, typeIncome2.size());				
				
	}
	
	@Test
	public void updatePayerRepository() {
		
		TypeIncome typeIncome = new TypeIncome();		
		typeIncome.setDescription("Teste Salvar");
		
		int idGerado = 0;
		
		HashMap<TypeIncome, Integer> newTypeIncome = typeIncomeService.insert(typeIncome);
		for(Map.Entry<TypeIncome, Integer> value : newTypeIncome.entrySet()) {
			idGerado = value.getValue();
		}		
		
		TypeIncome typeIncome2 = new TypeIncome();
		typeIncome2.setCode(idGerado);
		typeIncome2.setDescription("Teste Atualizar");
		
		typeIncomeService.update(typeIncome2);
		
		List<TypeIncome> listTypeIncome = new ArrayList<>();
		listTypeIncome = typeIncomeRepository.findByDescription("Teste Atualizar");
		
		Assertions.assertEquals(true,!listTypeIncome.isEmpty());		
	} 	
	
	@Test
	public void insertPayerRepository() {
		
		TypeIncome typeIncome = new TypeIncome();		
		typeIncome.setDescription("Teste Salvar");
		
		int idGerado = 0;
		
		HashMap<TypeIncome, Integer> newTypeIncome = typeIncomeService.insert(typeIncome);
		for(Map.Entry<TypeIncome, Integer> value : newTypeIncome.entrySet()) {
			idGerado = value.getValue();
		}
								
		Optional<List<TypeIncome>> list = Optional.ofNullable(typeIncomeService.listByCod(idGerado));
		
		Assertions.assertEquals(true,list.isPresent());				
	}
   
   
   @Test
   public void tearDown() {
	   
	   typeIncomeRepository.deleteAll();
   }

}
