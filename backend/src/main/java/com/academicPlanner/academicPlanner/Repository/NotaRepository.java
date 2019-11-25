package com.academicPlanner.academicPlanner.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academicPlanner.academicPlanner.Model.Materia;
import com.academicPlanner.academicPlanner.Model.Nota;
import com.academicPlanner.academicPlanner.Model.Usuario;

@Repository
public interface NotaRepository extends CrudRepository<Nota, Long> {

	List<Nota> findByMateria(Materia mat);
}
