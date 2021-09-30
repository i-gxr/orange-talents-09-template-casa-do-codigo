package br.com.zup.casa_do_codigo.controllers.requests;

import br.com.zup.casa_do_codigo.controllers.validation.ExistingId;
import br.com.zup.casa_do_codigo.controllers.validation.UniqueValue;
import br.com.zup.casa_do_codigo.entities.Autor;
import br.com.zup.casa_do_codigo.entities.Categoria;
import br.com.zup.casa_do_codigo.entities.Livro;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    @Lob
    private String sumario;

    @NotNull
    @Min(value = 100)
    private Integer qtdPaginas;

    @NotNull
    @DecimalMin(value = "20.0")
    private BigDecimal preco;

    @NotNull
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @ExistingId(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    @NotNull
    @ExistingId(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;

    public LivroRequest(String isbn, String titulo, String resumo, String sumario, Integer qtdPaginas, BigDecimal preco, LocalDate dataPublicacao, Long autorId, Long categoriaId) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.qtdPaginas = qtdPaginas;
        this.preco = preco;
        this.dataPublicacao = dataPublicacao;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Livro toModel(Autor autor, Categoria categoria) {
        return new Livro(isbn, titulo, resumo, sumario, qtdPaginas, preco, dataPublicacao, autor, categoria);
    }
}
