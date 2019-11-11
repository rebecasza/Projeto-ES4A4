package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entidades.Materia;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Long>{

}
