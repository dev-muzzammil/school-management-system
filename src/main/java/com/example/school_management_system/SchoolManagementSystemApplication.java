package com.example.school_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EntityScan("com.example.s_m_s_entities") 
@EnableJpaRepositories("com.example.s_m_s_repository")
@ComponentScan({"com.example.s_m_s_entities", "com.example.s_m_s_repository", "com.example.s_m_s_controller", "com.example.s_m_s_service"})


public class SchoolManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemApplication.class, args);
		
	}

}
