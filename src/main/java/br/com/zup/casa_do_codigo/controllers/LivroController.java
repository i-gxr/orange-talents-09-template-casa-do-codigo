package br.com.zup.casa_do_codigo.controllers;

import br.com.zup.casa_do_codigo.controllers.requests.LivroRequest;
import br.com.zup.casa_do_codigo.controllers.responses.LivroSimpleResponse;
import br.com.zup.casa_do_codigo.entities.Autor;
import br.com.zup.casa_do_codigo.entities.Categoria;
import br.com.zup.casa_do_codigo.entities.Livro;
import br.com.zup.casa_do_codigo.repositories.AutorRepository;
import br.com.zup.casa_do_codigo.repositories.CategoriaRepository;
import br.com.zup.casa_do_codigo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public List<LivroSimpleResponse> buscarTodos() {
        List<Livro> livros = StreamSupport
            .stream(repository.findAll().spliterator(), false)
            .collect(Collectors.toList());
        List<LivroSimpleResponse> livrosSimpleResponse = livros.stream()
            .map(l -> new LivroSimpleResponse(l.getId(), l.getTitulo()))
            .collect(Collectors.toList());
        return livrosSimpleResponse;
    }

    @PostMapping
    @Transactional
    public void inserir(@RequestBody @Valid LivroRequest request) {
        Livro livro = request.toModel(entityManager);
        repository.save(livro);
    }

}