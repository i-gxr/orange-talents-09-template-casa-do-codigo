package br.com.zup.casa_do_codigo.controllers.requests;

import br.com.zup.casa_do_codigo.entities.Autor;
import br.com.zup.casa_do_codigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest implements GenericRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorRequest(@NotBlank String nome,
                        @NotBlank @Email String email,
                        @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }

    @Override
    public String getValorUnico() {
        return this.getEmail();
    }

    @Override
    public String getNomeAtributoValorUnico() {
        return "email";
    }

    @Override
    public String getNomeTabela() {
        return "Autor";
    }
}