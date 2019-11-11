package com.academicPlanner.academicPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
        "com.academicPlanner.academicPlanner.Model"
        })
@EnableJpaRepositories(basePackages = {
        "com.academicPlanner.academicPlanner.Repository"
        })
public class AcademicPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicPlannerApplication.class, args);
		
		
	}

}
