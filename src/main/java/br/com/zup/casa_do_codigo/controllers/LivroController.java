package br.com.zup.casa_do_codigo.controllers;

import br.com.zup.casa_do_codigo.controllers.requests.LivroRequest;
import br.com.zup.casa_do_codigo.controllers.responses.LivroDetailsResponse;
import br.com.zup.casa_do_codigo.controllers.responses.LivroSimpleResponse;
import br.com.zup.casa_do_codigo.entities.Livro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public List<LivroSimpleResponse> buscarTodos() {
        List<LivroSimpleResponse> livrosSimpleResponse = entityManager.createQuery("SELECT l FROM Livro l", Livro.class)
            .getResultList().stream()
            .map(l -> new LivroSimpleResponse(l.getId(), l.getTitulo()))
            .collect(Collectors.toList());
        return livrosSimpleResponse;
    }

    @GetMapping("/{id}")
    public LivroDetailsResponse buscarPorId(@PathVariable Long id) {
        Optional<Livro> livro = Optional.ofNullable(entityManager.find(Livro.class, id));
        if (livro.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi encontrado nenhum livro com o id informado!");
        return new LivroDetailsResponse(livro.get());
    }

    @PostMapping
    @Transactional
    public void inserir(@RequestBody @Valid LivroRequest request) {
        Livro livro = request.toModel(entityManager);
        entityManager.persist(livro);
    }

}