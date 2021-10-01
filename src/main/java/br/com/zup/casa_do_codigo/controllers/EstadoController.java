package br.com.zup.casa_do_codigo.controllers;

import br.com.zup.casa_do_codigo.controllers.requests.EstadoRequest;
import br.com.zup.casa_do_codigo.entities.Estado;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public void inserir(@RequestBody @Valid EstadoRequest request) {
        Estado estado = request.toModel(entityManager);
        entityManager.persist(estado);
    }

}