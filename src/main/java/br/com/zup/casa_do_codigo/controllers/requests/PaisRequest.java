package br.com.zup.casa_do_codigo.controllers.requests;

import br.com.zup.casa_do_codigo.controllers.validation.UniqueValue;
import br.com.zup.casa_do_codigo.entities.Pais;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public PaisRequest() {}

    public PaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }

}
