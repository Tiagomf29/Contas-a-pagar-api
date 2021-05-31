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

import br.com.contasapi.domain.PaymentType;
import br.com.contasapi.repository.PaymentTypeRepository;
import br.com.contasapi.service.PaymentTypeService;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PayamentTypesTests {
	
	@Autowired
	PaymentTypeService paymentTypeService;
	@Autowired
	PaymentTypeRepository paymentTypeRespository;	
	
	@Test
	public void deletePayerRepository() {
		
		PaymentType paymentType = new PaymentType();		
		paymentType.setDescription("Teste Delete");
		
		int idGerado = 0;
		
		HashMap<PaymentType, Integer> newPayer = paymentTypeService.insert(paymentType);
		for(Map.Entry<PaymentType, Integer> value : newPayer.entrySet()) {
			idGerado = value.getValue();
		}	
		
		paymentTypeRespository.deleteById(idGerado);
		
		ArrayList<PaymentType> payer2 = new ArrayList<>();
		
		payer2 = paymentTypeService.listByCod(idGerado);
		
		Assertions.assertEquals(0, payer2.size());;					
				
	}
	
	@Test
	public void updatePayerRepository() {
		
		PaymentType paymentType = new PaymentType();		
		paymentType.setDescription("Teste Salvar");
		
		int idGerado = 0;
		
		HashMap<PaymentType, Integer> newPayer = paymentTypeService.insert(paymentType);
		for(Map.Entry<PaymentType, Integer> value : newPayer.entrySet()) {
			idGerado = value.getValue();
		}		
		
		PaymentType paymentType2 = new PaymentType();
		paymentType2.setCode(idGerado);
		paymentType2.setDescription("Teste Atualizar");
		
		paymentTypeService.update(paymentType2);
		
		List<PaymentType> listPayer = new ArrayList<>();
		listPayer = paymentTypeRespository.findByDescription("Teste Atualizar");
		
		Assertions.assertEquals(true,!listPayer.isEmpty());		
	} 	
	
	@Test
	public void insertPayerRepository() {
		
		PaymentType paymentType = new PaymentType();		
		paymentType.setDescription("Teste Salvar");
		
		int idGerado = 0;
		
		HashMap<PaymentType, Integer> newPayer = paymentTypeService.insert(paymentType);
		for(Map.Entry<PaymentType, Integer> value : newPayer.entrySet()) {
			idGerado = value.getValue();
		}
								
		Optional<List<PaymentType>> list = Optional.ofNullable(paymentTypeService.listByCod(idGerado));
		
		Assertions.assertEquals(true,list.isPresent());				
	}
   
    @Test
    public void tearDown() { 	   
 	   paymentTypeRespository.deleteAll();
    }
   

}
