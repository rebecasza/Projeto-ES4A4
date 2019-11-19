package com.academicPlanner.academicPlanner.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academicPlanner.academicPlanner.Model.Materia;
import com.academicPlanner.academicPlanner.Model.Usuario;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Long>{


	List<Materia> findByUsuario(Usuario user);
	
}
