package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entidades.Nota;

@Repository
public interface NotaRepository extends CrudRepository<Nota, Long> {

}
