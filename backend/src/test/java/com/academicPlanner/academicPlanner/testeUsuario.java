package com.academicPlanner.academicPlanner;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.academicPlanner.academicPlanner.Model.Usuario;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcademicPlannerApplication.class , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testeUsuario {
	  @LocalServerPort
	    private int port;

	    @Autowired
	    private Usuario usuario;
	    
	    @Autowired
	    private TestRestTemplate restTemplate;
	    
	    private String getRootUrl() {
	        return "http://localhost:" + port;
	    }
	    
	    @Test
	    public void testGetAllUsuario() {
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/usuarios",
	                HttpMethod.GET, entity, String.class);
	        assertNotNull(response.getBody());
	    }
}
