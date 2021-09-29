package br.com.zup.casa_do_codigo.controllers.requests;

import br.com.zup.casa_do_codigo.entities.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest implements GenericRequest {

    @NotBlank
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

    @Override
    public String getValorUnico() {
        return this.nome;
    }

    @Override
    public String getNomeAtributoValorUnico() {
        return "nome";
    }

    @Override
    public String getNomeTabela() {
        return "Categoria";
    }
}
