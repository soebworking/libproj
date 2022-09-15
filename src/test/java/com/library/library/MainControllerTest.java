package com.library.library;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.library.library.web.MainController;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MainControllerTest {
	
	
	@Autowired
	private MainController mainController;

	@Autowired
	TestRestTemplate testRestTemplate;
	
	String httpStr = "http://localhost:8080";
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(mainController).isNotNull();
	}
	
	
	
	@Test
	public void loginReturnMsg() throws Exception{
		
		assertThat(this.testRestTemplate.getForObject(httpStr + "/login", String.class).contains("login"));
		
	}
	
	@Test
	public void homeRetunMsg() throws Exception{
		assertThat(this.testRestTemplate.getForObject(httpStr + "/", String.class).contains("home"));
	}
	
	
}