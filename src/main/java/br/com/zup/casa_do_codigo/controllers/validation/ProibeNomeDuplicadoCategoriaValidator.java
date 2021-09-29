package br.com.zup.casa_do_codigo.controllers.validation;

import br.com.zup.casa_do_codigo.controllers.requests.CategoriaRequest;
import br.com.zup.casa_do_codigo.entities.Categoria;
import br.com.zup.casa_do_codigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;

        CategoriaRequest request = (CategoriaRequest) target;
        Optional<Categoria> possivelCategoria = repository.findByNome(request.getNome());

        if (possivelCategoria.isPresent())
            errors.rejectValue("nome", null,
                    "O nome informado já está sendo utilizado por outra categoria: "
                                 + request.getNome());

    }
}
