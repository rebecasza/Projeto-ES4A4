package com.academicPlanner.academicPlanner.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.academicPlanner.academicPlanner.Model.Materia;
import com.academicPlanner.academicPlanner.ModelApi.MateriaApi;
import com.academicPlanner.academicPlanner.Repository.MateriaRepository;
import com.academicPlanner.academicPlanner.Repository.UsuarioRepository;
import com.academicPlanner.academicPlanner.Service.Erro;
import com.academicPlanner.academicPlanner.Service.ResourceNotFoundException;

@RestController
public class MateriaController {
	
	private UsuarioRepository repositoryUser;
	private MateriaRepository repository;
	
	public MateriaController(UsuarioRepository repositoryUser, MateriaRepository repository) {
		super();
		this.repositoryUser = repositoryUser;
		this.repository = repository;
	}
	
	//Envia todas as matérias do usuário
	@GetMapping("/usuario/{id_user}/materia/all")
	public List<Materia> todasMaterias(@PathVariable Long id) {
		// Criar o método no repository findByUser()
	    return (List<Materia>) repository.findAll();

	} 
	
	// Criar materia
	@PostMapping ("/usuario/{id_user}/materia")
	public Object criar(@RequestBody @Valid MateriaApi materiaApi, BindingResult result, @PathVariable Long id) {
		if (result.hasErrors()) {
	        List<FieldError> errors = result.getFieldErrors();
	        List<String> message = new ArrayList<>();
	        for (FieldError e : errors){
	            message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
	        }
	        Erro erro = new Erro();
			erro.setMensagem("Impossível criar usuário");
	        erro.setCausa(message.toString());
	        return erro;
	    }
	    else
	    {
	    	Materia materia = new Materia();
	    	materia.setDescricao(materiaApi.getDescricao());
	    	materia.setNome(materiaApi.getNome());
	    	materia.setTipoMedia(materiaApi.getTipoMedia());
	    	materia.setUsuario(repositoryUser.findById(id).orElseThrow( () -> new ResourceNotFoundException("Usuário não encontrado")));
	    	
	    	return repository.save(materia);
	    }
		
	}
	
	
	// Puxar uma matéria pelo ID dela (o front mostrara todas as materias do user e pode chamar o materiaDetalhe)
	@GetMapping("/usuario/{idUser}/materia/{id}")
	public Materia materiaDetalhe(@PathVariable Long id) {
	  return repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Matéria não encontrado"));
	}
	

	// Editar materia
	
	
	// Deletar materia
	
	@DeleteMapping("/usuario/{idUser}/materia/{id}")
	public void usuarioDelete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
