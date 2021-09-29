package br.com.zup.casa_do_codigo.controllers;

import br.com.zup.casa_do_codigo.controllers.requests.CategoriaRequest;
import br.com.zup.casa_do_codigo.controllers.validation.ProibeNomeDuplicadoCategoriaValidator;
import br.com.zup.casa_do_codigo.entities.Categoria;
import br.com.zup.casa_do_codigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
    }

    @PostMapping
    @Transactional
    public void inserir(@RequestBody @Valid CategoriaRequest request) {
            Categoria categoria = request.toModel();
            repository.save(categoria);
    }

}