package br.com.contasapi.test.controller;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PayerControllerTests {
	
	
	String corpo ="{\"code\":\"1\", \"name\":\"Teste nome\"}";
	
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/payer";
    }
        
    public void getConsultAllPayer() {
    			
		Response response = given().contentType(ContentType.JSON).
		when().get("/all").
		then().extract().response();
		
		Assertions.assertEquals(200, response.statusCode());		
    	
    }

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
    

}
