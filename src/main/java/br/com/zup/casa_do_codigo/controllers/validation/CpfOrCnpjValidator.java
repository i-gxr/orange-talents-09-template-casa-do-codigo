package br.com.zup.casa_do_codigo.controllers.validation;

import br.com.zup.casa_do_codigo.controllers.requests.ClienteRequest;
import br.com.zup.casa_do_codigo.controllers.validation.utils.CpfCnpjUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CpfOrCnpjValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;

        ClienteRequest request = (ClienteRequest) target;
        String cpfOrCnpj = request.getDocumento();

        if (!CpfCnpjUtils.isValid(cpfOrCnpj))
            errors.rejectValue("documento", null,
                    "O documento errado não corresponde a um CPF/CNPJ: "
                            + request.getDocumento());

    }
}
