package com.academicPlanner.academicPlanner.Repository;

import java.util.List;
import com.academicPlanner.academicPlanner.Model.Materia;
import org.springframework.stereotype.Repository;
import com.academicPlanner.academicPlanner.Model.Topico;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TopicoRepository extends CrudRepository<Topico, Long>
{
    List<Topico> findByMateria(final Materia p0);
}