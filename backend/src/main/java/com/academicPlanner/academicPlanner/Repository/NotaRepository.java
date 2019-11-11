package com.academicPlanner.academicPlanner.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academicPlanner.academicPlanner.Model.Nota;

@Repository
public interface NotaRepository extends CrudRepository<Nota, Long> {

}
