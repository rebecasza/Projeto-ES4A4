package com.academicPlanner.academicPlanner.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academicPlanner.academicPlanner.Model.Estudo;
import com.academicPlanner.academicPlanner.Model.Usuario;


@Repository
public interface EstudoRepository extends CrudRepository<Estudo, Long> {

	List<Estudo> findByMateria(Long materia);
	List<Estudo> findByUsuario(Usuario user);
}