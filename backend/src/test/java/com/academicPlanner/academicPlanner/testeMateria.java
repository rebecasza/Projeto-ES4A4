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
import com.academicPlanner.academicPlanner.Model.Usuario;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcademicPlannerApplication.class , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testeMateria {
	  @LocalServerPort
	    private int port;

	    @Autowired
	    private Materia materia;
	    
	    private Usuario usuario;
	    
	    @Autowired
	    private TestRestTemplate restTemplate;
	    
	    private String getRootUrl() {
	        return "http://localhost:" + port;
	    }
	    
	    @Test
	    public void testGetAllMaterias() {
	    	int user = 1;
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/usuario/"+user+"/materia/all",
	                HttpMethod.GET, entity, String.class);
	        assertNotNull(response.getBody());
	    }
	    
	    @Test
	    public void testGetOneMateria() {
	    	int user = 1;
	    	int id = 1;
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/usuario/"+user+"/materia/"+ id,
	                HttpMethod.GET, entity, String.class);
	        assertNotNull(response.getBody());
	    }
	    
	    
	    @Test
	    public void testCriarMaterias() throws ParseException {
	    	int user = 1;
	        materia.setDescricao("Teste");
	        materia.setNome("NomeMateria");
	        materia.setTipoMedia(1);
	        materia.setUsuario(usuario);
	        ResponseEntity<Materia> postResponse = restTemplate.postForEntity(getRootUrl() + "/usuario/"+user+"/materia", materia, Materia.class );
	        assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
	    }
	    
}
