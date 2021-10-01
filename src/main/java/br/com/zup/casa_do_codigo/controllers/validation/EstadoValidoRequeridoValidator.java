package br.com.zup.casa_do_codigo.controllers.validation;

import br.com.zup.casa_do_codigo.controllers.requests.ClienteRequest;
import br.com.zup.casa_do_codigo.controllers.validation.utils.CpfCnpjUtils;
import br.com.zup.casa_do_codigo.entities.Estado;
import br.com.zup.casa_do_codigo.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Component
public class EstadoValidoRequeridoValidator implements Validator {

    @Autowired
    private EstadoRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;

        ClienteRequest request = (ClienteRequest) target;
        List<Estado> estadosOptional = repository.findByPaisId(request.getPaisId());

        if (!estadosOptional.isEmpty()) {
            if (request.getEstadoId() == null)
                errors.rejectValue("estadoId", null,
                        "O estado é obrigatório para o país informado!");
            else if (repository.findById(request.getEstadoId()).isEmpty())
                errors.rejectValue("estadoId", null,
                        "O id do estado informado não corresponde a nenhum estado!");
            else if (repository.findById(request.getEstadoId()).get().getPais().getId() != request.getPaisId())
                    errors.rejectValue("estadoId", null,
                            "O id do estado informado não pertence ao país informado!");
        }

    }
}
