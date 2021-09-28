package br.com.zup.casa_do_codigo.controllers;

import br.com.zup.casa_do_codigo.controllers.requests.AutorRequest;
import br.com.zup.casa_do_codigo.controllers.validation.ProibeEmailDuplicadoValidator;
import br.com.zup.casa_do_codigo.entities.Autor;
import br.com.zup.casa_do_codigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @Autowired
    private ProibeEmailDuplicadoValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping
    @Transactional
    public void inserir(@RequestBody @Valid AutorRequest request) {
            Autor autor = request.toModel();
            repository.save(autor);
    }

}