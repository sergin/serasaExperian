package com.serasa.experian;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.serasa.experian.api.controller.ControllerClient;
import com.serasa.experian.domain.model.Client;
import com.serasa.experian.domain.service.CatalogClientService;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest
class SergioLogApiApplicationTests {
	
	@Autowired
	ControllerClient controllerClient;
	
	@MockBean
	@Autowired
	CatalogClientService catalogClientService;

	/*@Test
	void contextLoads() {
	}*/
	
	@Test
	void okReturn() {
		

		
		RestAssuredMockMvc.given()
		.accept(ContentType.JSON)
		.when()
		.get("/clients/{codigo}", 1L)
		.then()
		.statusCode(HttpStatus.OK.value());
		
	}

	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.controllerClient);
	}
	
	@Test
	public void notFoundReturn() {
			
		RestAssuredMockMvc.given()
		.accept(ContentType.JSON)
		.when()
		.get("/clients/{codigo}", 20L)
		.then()
		.statusCode(HttpStatus.NOT_FOUND.value());
		
	}
}
