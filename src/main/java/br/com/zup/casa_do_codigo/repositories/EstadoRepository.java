package br.com.zup.casa_do_codigo.repositories;

import br.com.zup.casa_do_codigo.entities.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstadoRepository extends CrudRepository<Estado, Long> {

    List<Estado> findByPaisId(Long paisId);

}
