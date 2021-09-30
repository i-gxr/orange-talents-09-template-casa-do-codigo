package br.com.zup.casa_do_codigo.controllers;

import br.com.zup.casa_do_codigo.controllers.requests.LivroRequest;
import br.com.zup.casa_do_codigo.entities.Autor;
import br.com.zup.casa_do_codigo.entities.Categoria;
import br.com.zup.casa_do_codigo.entities.Livro;
import br.com.zup.casa_do_codigo.repositories.AutorRepository;
import br.com.zup.casa_do_codigo.repositories.CategoriaRepository;
import br.com.zup.casa_do_codigo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public void inserir(@RequestBody @Valid LivroRequest request) {
        Livro livro = request.toModel(entityManager);
        repository.save(livro);
    }

}