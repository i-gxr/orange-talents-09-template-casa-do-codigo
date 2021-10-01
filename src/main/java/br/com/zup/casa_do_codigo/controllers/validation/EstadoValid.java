package br.com.zup.casa_do_codigo.controllers.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {EstadoValidValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EstadoValid {

    String message() default "Já existe um estado com o mesmo nome no país informado!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    String fieldNameForeignKey();

    Class<?> domainClass();

}
