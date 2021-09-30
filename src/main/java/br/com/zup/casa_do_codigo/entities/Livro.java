package br.com.zup.casa_do_codigo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String resumo;

    @Column(nullable = false, columnDefinition = "CLOB")
    private String sumario;

    @Column(nullable = false)
    private Integer qtdPaginas;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
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

}
