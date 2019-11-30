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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academicPlanner.academicPlanner.Model.Usuario;
import com.academicPlanner.academicPlanner.Repository.UsuarioRepository;
import com.academicPlanner.academicPlanner.Service.Erro;
import com.academicPlanner.academicPlanner.Service.ResourceNotFoundException;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioController {

	
	private UsuarioRepository repository;
	
	public UsuarioController(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}
	
	// Mostrar todos os usuï¿½rios 
	
	@GetMapping("/all")
	public List<Usuario> todosUsuarios() {
	    return (List<Usuario>) repository.findAll();

	} 
	
	
	// Criar um usuï¿½rio
	
	@PostMapping ("/create")
	public Object criar(@RequestBody @Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
	        List<FieldError> errors = result.getFieldErrors();
	        List<String> message = new ArrayList<>();
	        for (FieldError e : errors){
	            message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
	        }
	        Erro erro = new Erro();
			erro.setMensagem("Impossï¿½vel Criar usuï¿½rio");
	        erro.setCausa(message.toString());
	        return erro;
	    }
	    else
	    {
	    	Usuario user1 = repository.findByEmail(usuario.getEmail());
	    	if(user1 != null) {
	    		Erro erro = new Erro();
				erro.setMensagem("Impossï¿½vel Criar usuï¿½rio");
				erro.setCausa("Email jï¿½ utilizado");
	    		return erro;
	    	}else {
	    		return repository.save(usuario);
	    	}
	    }
	}
	
	// Puxar um ï¿½nico usuï¿½rio
	
	@GetMapping("/{id}")
	public Usuario usuarioDetalhe(@PathVariable long id) {
	  return repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Usuï¿½rio nï¿½o encontrado"));
	 }
	
	// Editar um usuï¿½rio
	
	@PutMapping("/{id}")
	public Usuario usuarioEditar (@RequestBody Usuario usuarioEdit,@PathVariable long id) {
		
		return repository.findById(id).map(usuario -> {
			usuario.setNome(usuarioEdit.getNome());
			usuario.setSobrenome(usuarioEdit.getSobrenome());
			usuario.setEmail(usuarioEdit.getEmail());
			usuario.setSenha(usuarioEdit.getSenha());
			return repository.save(usuario);
		})
		.orElseThrow( () -> new ResourceNotFoundException("Usuï¿½rio nï¿½o encontrado"));
		
	}
	
	// Deletar um usuï¿½rio
	@DeleteMapping("/{id}")
	public String usuarioDelete(@PathVariable long id) {
		repository.deleteById(id);
		return "Usuário deletado com sucesso!";
	}	
}
