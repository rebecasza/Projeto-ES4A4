package com.academicPlanner.academicPlanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.academicPlanner.academicPlanner.Model.Estudo;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcademicPlannerApplication.class , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testeEstudo {
	  @LocalServerPort
	    private int port;

	    @Autowired
	    private Estudo estudo;
	    
}
