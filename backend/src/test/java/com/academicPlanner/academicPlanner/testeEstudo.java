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

import com.academicPlanner.academicPlanner.Model.Estudo;
import com.academicPlanner.academicPlanner.Model.Materia;
import com.academicPlanner.academicPlanner.Model.Usuario;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcademicPlannerApplication.class , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testeEstudo {
	  @LocalServerPort
	    private int port;

	    @Autowired
	    private Estudo estudo;
	    
	    private Usuario usuario;
	    
	    private Materia materia;
	    
	    @Autowired
	    private TestRestTemplate restTemplate;
	    
	    private String getRootUrl() {
	        return "http://localhost:" + port;
	    }
	    
	    @Test
	    public void testGetAllEstudo() {
	    	int user = 1;
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/usuario/"+ user + "/estudo/all",
	                HttpMethod.GET, entity, String.class);
	        assertNotNull(response.getBody());
	    }
	    
	    @Test
	    public void testGetOneEstudo() {
	    	int user = 1;
	    	int id = 1;
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/usuario/"+ user + "/estudo" + id,
	                HttpMethod.GET, entity, String.class);
	        assertNotNull(response.getBody());
	    }
	    
	    @Test
	    public void testCriarEstudo() throws ParseException {
	    	int user = 1;
	        estudo.setData("Teste");
	        estudo.setUsuario(usuario);
	        estudo.setMateria(materia);
	        ResponseEntity<Estudo> postResponse = restTemplate.postForEntity(getRootUrl() + "/usuario/"+ user + "/estudo", estudo, Estudo.class );
	        assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
	    }
	    
}
