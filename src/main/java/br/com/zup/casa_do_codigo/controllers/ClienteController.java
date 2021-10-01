package br.com.zup.casa_do_codigo.controllers;

import br.com.zup.casa_do_codigo.controllers.requests.CategoriaRequest;
import br.com.zup.casa_do_codigo.controllers.requests.ClienteRequest;
import br.com.zup.casa_do_codigo.controllers.validation.CpfOrCnpjValidator;
import br.com.zup.casa_do_codigo.controllers.validation.EstadoValidoRequeridoValidator;
import br.com.zup.casa_do_codigo.entities.Categoria;
import br.com.zup.casa_do_codigo.entities.Cliente;
import br.com.zup.casa_do_codigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CpfOrCnpjValidator cpfOrCnpjValidator;

    @Autowired
    private EstadoValidoRequeridoValidator estadoValidoRequeridoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(cpfOrCnpjValidator);
        binder.addValidators(estadoValidoRequeridoValidator);
    }

    @PostMapping
    @Transactional
    public String inserir(@RequestBody @Valid ClienteRequest request) {
        Cliente cliente = request.toModel(entityManager);
        entityManager.persist(cliente);
        return cliente.getId().toString();
    }

}