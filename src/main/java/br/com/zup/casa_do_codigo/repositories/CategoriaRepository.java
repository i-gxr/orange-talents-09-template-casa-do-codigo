package br.com.zup.casa_do_codigo.repositories;

import br.com.zup.casa_do_codigo.entities.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    Optional<Categoria> findByNome(String nome);

}
