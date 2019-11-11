package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entidades.Usuario;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
