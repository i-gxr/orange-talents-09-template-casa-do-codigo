package br.com.zup.casa_do_codigo.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @Column(nullable = false)
    @NotBlank
    private String sobrenome;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String documento;

    @Column(nullable = false)
    @NotBlank
    private String endereco;

    @Column(nullable = true)
    @NotBlank
    private String complemento;

    @Column(nullable = false)
    @NotBlank
    private String cidade;

    @Column(nullable = false)
    @NotBlank
    private String telefone;

    @Column(nullable = false)
    @NotBlank
    private String cep;

    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    public Cliente(String nome, String sobrenome, String email, String documento, String endereco, String complemento, String cidade, String telefone, String cep, Pais pais) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
