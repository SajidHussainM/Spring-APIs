package com.company.proj1.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.proj1.DB;
import com.company.proj1.DevDB;
import com.company.proj1.ProdDB;

@Configuration
public class AppConfig {
	@Bean
	@ConditionalOnProperty(name = "project.mode", havingValue = "production")
	public DB getProdData() {
		return new ProdDB();
	}
	
	@Bean
	@ConditionalOnProperty(name = "project.mode", havingValue = "development")
	public DB getDevData() {
		return new DevDB();
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
