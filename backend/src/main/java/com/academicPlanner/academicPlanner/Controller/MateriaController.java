package com.academicPlanner.academicPlanner.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.academicPlanner.academicPlanner.Repository.MateriaRepository;
import com.academicPlanner.academicPlanner.Repository.UsuarioRepository;

@RestController
public class MateriaController {
	
	private UsuarioRepository repositoryUser;
	private MateriaRepository repository;
	
	public MateriaController(UsuarioRepository repositoryUser, MateriaRepository repository) {
		super();
		this.repositoryUser = repositoryUser;
		this.repository = repository;
	}
}
