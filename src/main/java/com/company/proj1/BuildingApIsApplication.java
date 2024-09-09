package com.company.proj1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.company.proj1.config.repository")
public class BuildingApIsApplication implements CommandLineRunner{
	@Autowired
	DB db;
	public static void main(String[] args) {
		SpringApplication.run(BuildingApIsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		db.getData();
	}

}
