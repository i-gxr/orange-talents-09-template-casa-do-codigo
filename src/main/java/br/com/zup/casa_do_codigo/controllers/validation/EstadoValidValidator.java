package br.com.zup.casa_do_codigo.controllers.validation;

import br.com.zup.casa_do_codigo.controllers.requests.EstadoRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EstadoValidValidator implements ConstraintValidator<EstadoValid, EstadoRequest> {

    private String domainAttribute;
    private String foreignKeyAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(EstadoValid params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
        foreignKeyAttribute = params.fieldNameForeignKey();
    }

    @Override
    public boolean isValid(EstadoRequest value, ConstraintValidatorContext context) {
        Query query = em.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE " + domainAttribute + " = :valueDomainAttribute "
                                     + "AND " + foreignKeyAttribute + " = :valueForeignKeyAttribute");
        query.setParameter("valueDomainAttribute", value.getNome());
        query.setParameter("valueForeignKeyAttribute", value.getPaisId());
        List<?> list = query.getResultList();
        return list.isEmpty();
    }
}
