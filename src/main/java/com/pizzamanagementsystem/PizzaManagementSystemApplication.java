package com.pizzamanagementsystem;

import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzaManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaManagementSystemApplication.class, args);
			
		
	}
	
//Model Mapper
	 @Bean
	   ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
