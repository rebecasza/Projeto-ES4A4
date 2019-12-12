package com.academicPlanner.academicPlanner;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.academicPlanner.academicPlanner.Model.Materia;
import com.academicPlanner.academicPlanner.Model.Nota;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcademicPlannerApplication.class , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testeNota {
	  @LocalServerPort
	    private int port;

	    @Autowired
	    private Nota nota;
	    
	    private Materia materia;
	    
	    @Autowired
	    private TestRestTemplate restTemplate;
	    
	    private String getRootUrl() {
	        return "http://localhost:" + port;
	    }
	    
	    @Test
	    public void testGetAllNotas() {
	    	int id = 1;
	    	int user = 1;
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/usuario/" + user +"/materia/" + id + "/nota/all",
	                HttpMethod.GET, entity, String.class);
	        assertNotNull(response.getBody());
	    }
	    
	    
	    @Test
	    public void testCriarNota() throws ParseException {
	    	int id = 1;
	    	int user = 1;
	        nota.setDescricao("Teste");
	        nota.setPeso(1);
	        nota.setValor(1);
	        nota.setMateria(materia);
	        ResponseEntity<Nota> postResponse = restTemplate.postForEntity(getRootUrl() + "/usuario/" + user +"/materia/" + id + "/nota", nota, Nota.class );
	        assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
	    }
	    
}
