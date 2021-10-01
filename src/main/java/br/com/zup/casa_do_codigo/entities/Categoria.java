package br.com.zup.casa_do_codigo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String nome;

    @Deprecated
    public Categoria() {}

    public Categoria(String nome) {
        this.nome = nome;
    }

}
