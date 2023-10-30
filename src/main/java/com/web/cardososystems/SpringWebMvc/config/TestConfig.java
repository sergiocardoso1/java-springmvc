package com.web.cardososystems.SpringWebMvc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.cardososystems.SpringWebMvc.repository.DBServiceImpl;

@Configuration
public class TestConfig {

	@Autowired
	private DBServiceImpl dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	

}
