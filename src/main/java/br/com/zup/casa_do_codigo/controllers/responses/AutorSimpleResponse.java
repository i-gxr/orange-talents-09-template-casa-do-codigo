package br.com.zup.casa_do_codigo.controllers.responses;

public class AutorSimpleResponse {

    private String nome;
    private String descricao;

    public AutorSimpleResponse(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
