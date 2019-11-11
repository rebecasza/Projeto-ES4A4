package com.academicPlanner.academicPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.academicPlanner.academicPlanner.Model.Usuario;
import com.academicPlanner.academicPlanner.Repository.UsuarioRepository;

@SpringBootApplication
public class AcademicPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicPlannerApplication.class, args);
		
		
	}

}
