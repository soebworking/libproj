package com.library.library;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.library.library.web.MainController;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MainControllerTest {
	
	
	@Autowired
	private MainController mainController;
	
	@Value("${local.server.port}")
	int port;

	@Autowired
	TestRestTemplate testRestTemplate;
	
	String httpStr = "http://localhost:"+port;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(mainController).isNotNull();
	}
	
	
	
	@Test
	public void loginReturnMsg() throws Exception{
		
		//assertThat(this.testRestTemplate.getForObject(httpStr + "/login", String.class).contains("login"));
		
		ResponseEntity<String> response = testRestTemplate.getForEntity("/login", String.class);     
        assertThat(response.getStatusCode());

		
	}
	
	@Test
	public void homeRetunMsg() throws Exception{
		//assertThat(this.testRestTemplate.getForObject(httpStr + "/", String.class).contains("home"));
	}
	
	
}