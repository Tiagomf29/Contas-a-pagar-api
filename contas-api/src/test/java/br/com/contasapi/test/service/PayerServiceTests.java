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

import br.com.contasapi.domain.Payer;
import br.com.contasapi.repository.PayerRespository;
import br.com.contasapi.service.PayerService;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PayerServiceTests {
	
	@Autowired
	PayerService payerService;
	@Autowired
	PayerRespository payerRespoitory;	
	/*
	String corpo ="{\"code\":\"1\", \"name\":\"Teste nome\"}";
	
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/payer";
    }
    
    @Test
    public void getConsultAllPayer() {
    			
		Response response = given().contentType(ContentType.JSON).
		when().get("/all").
		then().extract().response();
		
		Assertions.assertEquals(200, response.statusCode());		
    	
    }

    @Test
	public void postInsertPayer() {
		
		Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(corpo)
                .when()
                .post("/insert")
                .then()
                .extract().response();
		
		Assertions.assertEquals(200, response.getStatusCode());
		
	}
		
	public void putUpdatePayer() {
		
		Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(corpo)
                .when()
                .put("/update")
                .then()
                .extract().response();
		
		Assertions.assertEquals(200, response.getStatusCode());
		
	}	
		
	public void deletePayer() {
		
		Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(corpo)
                .when()
                .delete("/delete/1")
                .then()
                .extract().response();
		
		Assertions.assertEquals(204, response.getStatusCode());		
	}
    */
	@Test
	public void deletePayerRepository() {
		
		Payer payer = new Payer();		
		payer.setName("Teste Delete");
		
		int idGerado = 0;
		
		HashMap<Payer, Integer> newPayer = payerService.insert(payer);
		for(Map.Entry<Payer, Integer> value : newPayer.entrySet()) {
			idGerado = value.getValue();
		}	
		
		payerRespoitory.deleteById(idGerado);
		
		ArrayList<Payer> payer2 = new ArrayList<>();
		
		payer2 = payerService.listById(idGerado);
		
		Assertions.assertNull(payer2);					
				
	}
	
	@Test
	public void updatePayerRepository() {
		
		Payer payer = new Payer();		
		payer.setName("Teste Salvar");
		
		int idGerado = 0;
		
		HashMap<Payer, Integer> newPayer = payerService.insert(payer);
		for(Map.Entry<Payer, Integer> value : newPayer.entrySet()) {
			idGerado = value.getValue();
		}		
		
		Payer payer2 = new Payer();
		payer2.setCode(idGerado);
		payer2.setName("Teste Atualizar");
		
		payerService.update(payer2);
		
		List<Payer> listPayer = new ArrayList<>();
		listPayer = payerRespoitory.findByName("Teste Atualizar");
		
		Assertions.assertEquals(false,!listPayer.isEmpty());		
	} 	
	
	@Test
	public void insertPayerRepository() {
		
		Payer payer = new Payer();		
		payer.setName("Teste Salvar");
		
		int idGerado = 0;
		
		HashMap<Payer, Integer> newPayer = payerService.insert(payer);
		for(Map.Entry<Payer, Integer> value : newPayer.entrySet()) {
			idGerado = value.getValue();
		}
								
		Optional<List<Payer>> list = Optional.ofNullable(payerService.listById(idGerado));
		
		Assertions.assertEquals(true,list.isPresent());				
	}
   
   
   @Test
   public void tearDown() {
	   
	   payerRespoitory.deleteAll();
   }

}
