package com.academicPlanner.academicPlanner;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.academicPlanner.academicPlanner.entidades.UsuarioRepository;
import com.academicPlanner.academicPlanner.entidades.ResourceNotFoundException;
import com.academicPlanner.academicPlanner.entidades.Usuario;



@RestController
public class UsuarioController {

	
	private UsuarioRepository repository;
	
	public UsuarioController(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}
	
	// Mostrar todos os usu�rios 
	
	@GetMapping("/usuarios/all")
	public List<Usuario> todosUsuarios() {
	    return (List<Usuario>) repository.findAll();

	} 
	
	
	// Criar um usu�rio
	
	@PostMapping ("/create")
	public Object criar(@RequestBody @Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
	        List<FieldError> errors = result.getFieldErrors();
	        List<String> message = new ArrayList<>();
	        for (FieldError e : errors){
	            message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
	        }
	        Erro erro = new Erro();
			erro.setMensagem("Imposs�vel Criar usu�rio");
	        erro.setCausa(message.toString());
	        return erro;
	    }
	    else
	    {
	    	Usuario user1 = repository.findByEmail(usuario.getEmail());
	    	if(user1 != null) {
	    		Erro erro = new Erro();
				erro.setMensagem("Imposs�vel Criar usu�rio");
				erro.setCausa("Email j� utilizado");
	    		return erro;
	    	}else {
	    		return repository.save(usuario);
	    	}
	    }

	}
	
	// Puxar um �nico usu�rio
	
	@GetMapping("/usuario/{id}")
	public Usuario usuarioDetalhe(@PathVariable Long id) {
	  return repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Usu�rio n�o encontrado"));
	 }
	
	// Editar um usu�rio
	
	@PutMapping("/usuario/{id}")
	public Usuario usuarioEditar (@RequestBody Usuario usuarioEdit,@PathVariable Long id) {
		
		return repository.findById(id).map(usuario -> {
			usuario.setNome(usuarioEdit.getNome());
			usuario.setSobrenome(usuarioEdit.getSobrenome());
			usuario.setEmail(usuarioEdit.getEmail());
			usuario.setSenha(usuarioEdit.getSenha());
			return repository.save(usuario);
		})
		.orElseThrow( () -> new ResourceNotFoundException("Usu�rio n�o encontrado"));
		
	}
	
	// Deletar um usu�rio
	@DeleteMapping("usuario/{id}")
	public void usuarioDelete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
}