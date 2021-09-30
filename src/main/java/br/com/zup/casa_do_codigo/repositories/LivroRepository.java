package br.com.zup.casa_do_codigo.repositories;

import br.com.zup.casa_do_codigo.entities.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, String> {

}
