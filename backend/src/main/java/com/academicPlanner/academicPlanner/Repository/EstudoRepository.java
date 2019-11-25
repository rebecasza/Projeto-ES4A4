package com.academicPlanner.academicPlanner.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academicPlanner.academicPlanner.Model.Estudo;

@Repository
public interface EstudoRepository extends CrudRepository<Estudo, Long> {

	List<Estudo> findByMateria(Long materia);
}
