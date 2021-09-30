package br.com.zup.casa_do_codigo.controllers.responses;

public class LivroSimpleResponse {

    private Long id;
    private String titulo;

    public LivroSimpleResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
