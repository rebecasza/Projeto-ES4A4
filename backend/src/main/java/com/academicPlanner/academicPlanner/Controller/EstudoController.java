package com.academicPlanner.academicPlanner.Controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.academicPlanner.academicPlanner.Model.Estudo;
import com.academicPlanner.academicPlanner.Model.Materia;
import com.academicPlanner.academicPlanner.Model.Usuario;
import com.academicPlanner.academicPlanner.ModelApi.EstudoApi;
import com.academicPlanner.academicPlanner.ModelApi.MateriaApi;
import com.academicPlanner.academicPlanner.Repository.EstudoRepository;
import com.academicPlanner.academicPlanner.Repository.MateriaRepository;
import com.academicPlanner.academicPlanner.Repository.UsuarioRepository;
import com.academicPlanner.academicPlanner.Service.Erro;
import com.academicPlanner.academicPlanner.Service.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "*")
public class EstudoController {
	
	private UsuarioRepository repositoryUser;
	private EstudoRepository repository;
	
	public EstudoController(UsuarioRepository repositoryUser, EstudoRepository repository) {
		super();
		this.repositoryUser = repositoryUser;
		this.repository = repository;
	}
	//Envia todos os estudo do usuário
	@GetMapping("/usuario/estudo/all")
	public List<Estudo> todasestudo() {
					
	    return (List<Estudo>) repository.findAll();

	} 
	// Criar estudo
	@PostMapping ("/usuario/{userId}/materia/{materiaId}/estudo")
	public Object criar(@RequestBody @Valid EstudoApi estudoApi, BindingResult result, @PathVariable int userId, @PathVariable int materiaId) {
			if (result.hasErrors()) {
		        List<FieldError> errors = result.getFieldErrors();
		        List<String> message = new ArrayList<>();
		        for (FieldError e : errors){
		            message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
		        }
		        Erro erro = new Erro();
				erro.setMensagem("Impossível criar estudo");
		        erro.setCausa(message.toString());
		        return erro;
		    }
		    else
		    {
		    	Estudo estudo = new Estudo();
		    	estudo.setData(estudoApi.getData());
		    	estudo.setUsuario(userId);
		    	estudo.setMateria(materiaId);
		    	
		    	return repository.save(estudo);
		    }
			
		}
	
	// Editar estudo
	
	@PutMapping("/usuario/{user}/estudo/{id}")
	public Estudo estudoEditar (@RequestBody Estudo estudoEdit,@PathVariable long id) {
		
		return repository.findById(id).map(estudo -> {
			estudo.setData(estudoEdit.getData());
			return repository.save(estudo);
		})
		.orElseThrow( () -> new ResourceNotFoundException("Materia não encontrado"));
		
	}
	
	// Deletar estudo
	
	@DeleteMapping("/usuario/{user}/estudo/{id}")
	public String estudoDelete(@PathVariable Long id) {
		repository.deleteById(id);
		return "Materia deletada com sucesso!";
	}
}
