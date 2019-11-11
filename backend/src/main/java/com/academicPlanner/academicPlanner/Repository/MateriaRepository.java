package com.academicPlanner.academicPlanner.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academicPlanner.academicPlanner.Model.Materia;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Long>{

}
