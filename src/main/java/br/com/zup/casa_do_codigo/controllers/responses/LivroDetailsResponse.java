package br.com.zup.casa_do_codigo.controllers.responses;

import br.com.zup.casa_do_codigo.entities.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetailsResponse {

    private String isbn;

    private String titulo;

    private String resumo;

    private String sumario;

    private Integer qtdPaginas;

    private BigDecimal preco;

    private LocalDate dataPublicacao;

    private AutorSimpleResponse autor;

    public LivroDetailsResponse(Livro livro) {
        this.isbn = livro.getIsbn();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.qtdPaginas = livro.getQtdPaginas();
        this.preco = livro.getPreco();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = new AutorSimpleResponse(livro.getAutor().getNome(), livro.getAutor().getDescricao());
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorSimpleResponse getAutor() {
        return autor;
    }
}
