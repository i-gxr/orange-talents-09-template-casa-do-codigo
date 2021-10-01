package br.com.zup.casa_do_codigo.controllers.requests;

import br.com.zup.casa_do_codigo.controllers.validation.EstadoValid;
import br.com.zup.casa_do_codigo.controllers.validation.ExistingId;
import br.com.zup.casa_do_codigo.controllers.validation.UniqueValue;
import br.com.zup.casa_do_codigo.entities.Categoria;
import br.com.zup.casa_do_codigo.entities.Estado;
import br.com.zup.casa_do_codigo.entities.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EstadoValid(domainClass = Estado.class, fieldName = "nome", fieldNameForeignKey = "pais_id")
public class EstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @ExistingId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    @Deprecated
    public EstadoRequest() {}

    public EstadoRequest(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado toModel(EntityManager em) {
        Pais pais = em.find(Pais.class, paisId);
        return new Estado(this.nome, pais);
    }

}
