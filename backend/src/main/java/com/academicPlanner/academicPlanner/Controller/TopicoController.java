package com.academicPlanner.academicPlanner.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Iterator;
import com.academicPlanner.academicPlanner.Service.Erro;
import org.springframework.validation.FieldError;
import java.util.ArrayList;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import com.academicPlanner.academicPlanner.ModelApi.TopicoApi;
import org.springframework.web.bind.annotation.GetMapping;
import com.academicPlanner.academicPlanner.Service.ResourceNotFoundException;
import com.academicPlanner.academicPlanner.Model.Materia;
import com.academicPlanner.academicPlanner.Model.Topico;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import com.academicPlanner.academicPlanner.Repository.MateriaRepository;
import com.academicPlanner.academicPlanner.Repository.TopicoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "*" })
public class TopicoController
{
    private TopicoRepository repository;
    private MateriaRepository repositoryMateria;
    
    public TopicoController(final TopicoRepository repository, final MateriaRepository repositoryMateria) {
        this.repository = repository;
        this.repositoryMateria = repositoryMateria;
    }
    
    @GetMapping({ "/usuario/{user}/materia/{id}/topico/all" })
    public List<Topico> todosTopicos(@PathVariable final Long id) {
        Materia mat = this.repositoryMateria.findById(id).orElseThrow(() -> new ResourceNotFoundException("Materia n\u00e3o encontrado"));
        return (List<Topico>)this.repository.findByMateria(mat);
    }
    
    @GetMapping({ "/usuario/{user}/materia/{materia}/topico/{id}" })
    public Topico topicoDetalhe(@PathVariable final Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topico n\u00e3o encontrado"));
    }
    
    @PostMapping({ "/usuario/{user}/materia/{id}/topico" })
    public Object criar(@RequestBody @Valid final TopicoApi topicoApi, final BindingResult result, @PathVariable final Long id) {
        if (result.hasErrors()) {
            final List<FieldError> errors = (List<FieldError>)result.getFieldErrors();
            final List<String> message = new ArrayList<String>();
            for (final FieldError e : errors) {
                message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
            }
            final Erro erro = new Erro();
            erro.setMensagem("Imposs\u00edvel criar topica");
            erro.setCausa(message.toString());
            return erro;
        }
        Topico topico = new Topico();
        topico.setNome(topicoApi.getNome());
        topico.setDescricao(topicoApi.getDescricao());
        topico.setMateria(this.repositoryMateria.findById(id).orElseThrow(() -> new ResourceNotFoundException("Materia n\u00e3o encontrada")));
        return this.repository.save(topico);
    }
    
    @PutMapping({ "/usuario/{user}/materia/{materia}/topico/{id}" })
    public Topico topicoEditar(@RequestBody final Topico topicoEdit, @PathVariable final long id) {
        return this.repository.findById(id).map(topico -> {
            topico.setDescricao(topicoEdit.getDescricao());
            return (Topico)this.repository.save(topico);
        }).orElseThrow(() -> new ResourceNotFoundException("Nota n\u00e3o encontrado"));
    }
    
    @DeleteMapping({ "/usuario/{user}/materia/{materia}/topico/{id}" })
    public String topicoDelete(@PathVariable final Long id) {
        this.repository.deleteById(id);
        return "Topico deletada com sucesso!";
    }
}