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

import com.academicPlanner.academicPlanner.Model.Materia;
import com.academicPlanner.academicPlanner.Model.Nota;
import com.academicPlanner.academicPlanner.Model.Usuario;
import com.academicPlanner.academicPlanner.ModelApi.MateriaApi;
import com.academicPlanner.academicPlanner.ModelApi.NotaApi;
import com.academicPlanner.academicPlanner.Repository.MateriaRepository;
import com.academicPlanner.academicPlanner.Repository.NotaRepository;
import com.academicPlanner.academicPlanner.Repository.UsuarioRepository;
import com.academicPlanner.academicPlanner.Service.Erro;
import com.academicPlanner.academicPlanner.Service.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "*")
public class NotaController {

	private NotaRepository repository;
	private MateriaRepository repositoryMateria;
	

	public NotaController(NotaRepository repository, MateriaRepository repositoryMateria) {
		super();
		this.repository = repository;
		this.repositoryMateria = repositoryMateria;
	}

	// Envia todas as notas de uma matéria
	@GetMapping("/usuario/{user}/materia/{id}/nota/all")
	public List<Nota> todasNotas(@PathVariable Long id) {
		
		
		Materia mat = repositoryMateria.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Materia não encontrado"));

		// Criar o método no repository findByMateria()
		return  (List<Nota>) repository.findByMateria(mat);

	}
	
	@GetMapping("/usuario/{user}/materia/{id}/nota/media")
	public double media (@PathVariable Long id) {
		Nota nota = new Nota();
		return nota.media(id);
	}
	
	// Envia uma nota de uma matéria
	@GetMapping("/usuario/{user}/materia/{materia}/nota/{id}")
	public Nota notaDetalhe(@PathVariable Long id) {
	  return repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Nota não encontrado"));
	}
	
	
	// Criar nota
	@PostMapping ("/usuario/{user}/materia/{id}/nota")
		public Object criar(@RequestBody @Valid NotaApi notaApi, BindingResult result, @PathVariable Long id) {
			if (result.hasErrors()) {
		        List<FieldError> errors = result.getFieldErrors();
		        List<String> message = new ArrayList<>();
		        for (FieldError e : errors){
		            message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
		        }
		        Erro erro = new Erro();
				erro.setMensagem("Impossível criar nota");
		        erro.setCausa(message.toString());
		        return erro;
		    }
		    else
		    {
		    	Nota nota = new Nota();
		    	nota.setDescricao(notaApi.getDescricao());
		    	nota.setPeso(notaApi.getPeso());
		    	nota.setValor(notaApi.getValor());
		    	nota.setMateria(repositoryMateria.findById(id).orElseThrow( () -> new ResourceNotFoundException("Materia não encontrada")));
		    	
		    	return repository.save(nota);
		    }
			
		}
		
		// Editar uma nota
		@PutMapping("/usuario/{user}/materia/{materia}/nota/{id}")
		public Nota notaEditar (@RequestBody Nota notaEdit,@PathVariable long id) {
			
			return repository.findById(id).map(nota -> {
				nota.setDescricao(notaEdit.getDescricao());
				nota.setPeso(notaEdit.getPeso());
				nota.setValor(notaEdit.getValor());
				return repository.save(nota);
			})
			.orElseThrow( () -> new ResourceNotFoundException("Nota não encontrado"));
			
		}
		
		// Deletar uma nota
		@DeleteMapping("/usuario/{user}/materia/{materia}/nota/{id}")
		public String notaDelete(@PathVariable Long id) {
			repository.deleteById(id);
			return "Nota deletada com sucesso!";
		}
}
