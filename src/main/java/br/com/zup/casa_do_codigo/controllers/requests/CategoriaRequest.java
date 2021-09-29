package br.com.zup.casa_do_codigo.controllers.requests;

import br.com.zup.casa_do_codigo.controllers.validation.UniqueValue;
import br.com.zup.casa_do_codigo.entities.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public CategoriaRequest() {}

    public CategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

}
