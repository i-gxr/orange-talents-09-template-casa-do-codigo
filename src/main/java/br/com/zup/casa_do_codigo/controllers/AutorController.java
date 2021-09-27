package br.com.zup.casa_do_codigo.controllers;

import br.com.zup.casa_do_codigo.repositories.AutorRepository;
import br.com.zup.casa_do_codigo.controllers.requests.AutorRequest;
import br.com.zup.casa_do_codigo.entities.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    public void inserir(@RequestBody @Valid AutorRequest request) {
        Autor autor = request.toModel();
        repository.save(autor);
    }

}
