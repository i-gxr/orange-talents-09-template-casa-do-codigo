package br.com.zup.casa_do_codigo.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String isbn;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String titulo;

    @Column(nullable = false, length = 500)
    @NotBlank
    @Size(max = 500)
    private String resumo;

    @Column(nullable = false, columnDefinition = "CLOB")
    @NotBlank
    @Lob
    private String sumario;

    @Column(nullable = false)
    @NotNull
    @Min(value = 100)
    private Integer qtdPaginas;

    @Column(nullable = false)
    @NotNull
    @DecimalMin(value = "20.0")
    private BigDecimal preco;

    @Column(nullable = false)
    @NotNull
    @Future
    private LocalDate dataPublicacao;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Categoria categoria;

    @Deprecated
    public Livro() {}

    public Livro(String isbn, String titulo, String resumo, String sumario, Integer qtdPaginas, BigDecimal preco, LocalDate dataPublicacao, Autor autor, Categoria categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.qtdPaginas = qtdPaginas;
        this.preco = preco;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
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

    public Autor getAutor() {
        return autor;
    }
}
