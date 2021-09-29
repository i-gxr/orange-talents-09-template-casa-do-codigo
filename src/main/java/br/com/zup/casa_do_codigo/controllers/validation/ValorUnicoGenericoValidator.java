package br.com.zup.casa_do_codigo.controllers.validation;

import br.com.zup.casa_do_codigo.controllers.requests.GenericRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ValorUnicoGenericoValidator implements Validator {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean supports(Class<?> clazz) {
        return GenericRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;

        GenericRequest request = (GenericRequest) target;

        List<Object> resultList = (List<Object>) em
                .createQuery("SELECT x FROM " + request.getNomeTabela() + " x"
                                    + " WHERE x." + request.getNomeAtributoValorUnico()
                                    + " = :valor")
                .setParameter("valor", request.getValorUnico())
                .getResultList();

        if (!resultList.isEmpty())
            errors.rejectValue(request.getNomeAtributoValorUnico(), null,
            "O dado informado já está sendo utilizado!: "
                    + request.getValorUnico());

    }
}
