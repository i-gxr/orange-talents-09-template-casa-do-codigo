package br.com.zup.casa_do_codigo.repositories;

import br.com.zup.casa_do_codigo.entities.Autor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);

}
