package br.com.zup.casa_do_codigo.controllers.validation;

import br.com.zup.casa_do_codigo.controllers.requests.AutorRequest;
import br.com.zup.casa_do_codigo.entities.Autor;
import br.com.zup.casa_do_codigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;

        AutorRequest request = (AutorRequest) target;
        Optional<Autor> possivelAutor = repository.findByEmail(request.getEmail());

        if (possivelAutor.isPresent())
            errors.rejectValue("email", null,
                    "O e-mail informado já está sendo utilizado por outro(a) autor(a): "
                                 + request.getEmail());

    }
}
