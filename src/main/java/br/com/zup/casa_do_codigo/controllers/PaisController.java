package br.com.zup.casa_do_codigo.controllers;

import br.com.zup.casa_do_codigo.controllers.requests.CategoriaRequest;
import br.com.zup.casa_do_codigo.controllers.requests.PaisRequest;
import br.com.zup.casa_do_codigo.entities.Categoria;
import br.com.zup.casa_do_codigo.entities.Pais;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public void inserir(@RequestBody @Valid PaisRequest request) {
        Pais pais = request.toModel();
        entityManager.persist(pais);
    }

}