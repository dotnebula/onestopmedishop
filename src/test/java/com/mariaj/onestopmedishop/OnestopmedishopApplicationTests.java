package com.mariaj.onestopmedishop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.mariaj.onestopmedishop.controllers.MedicationController;

@SpringBootTest
class OnestopmedishopApplicationTests {
	
//	@Autowired
//	private MedicationController medicationController;
//	
//	@LocalServerPort
//	private int randomPort;
//	
//	@Autowired
//	private TestRestTemplate restTempClient;
//	
//	@Test
//	@DisplayName("Application context should not be null")
//	void contextLoads() {
//		assertNotNull(medicationController);
//	}
//	
//	@Test
//	@DisplayName("Application server should be running")
//	void serverLoadingTest() {
//		String URL ="http://localhost:"+randomPort+"/medi";
//		ResponseEntity<String> response = restTempClient.getForEntity(URL, String.class);		
//		assertEquals("Hello, Server is up and running !", response.getBody());
//		assertEquals(200, response.getStatusCodeValue());
//	}

}
