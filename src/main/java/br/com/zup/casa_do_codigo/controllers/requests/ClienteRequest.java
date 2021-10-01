package br.com.zup.casa_do_codigo.controllers.requests;

import br.com.zup.casa_do_codigo.controllers.validation.ExistingId;
import br.com.zup.casa_do_codigo.controllers.validation.UniqueValue;
import br.com.zup.casa_do_codigo.entities.Cliente;
import br.com.zup.casa_do_codigo.entities.Estado;
import br.com.zup.casa_do_codigo.entities.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @NotNull
    @ExistingId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    private Long estadoId;

    public ClienteRequest(String nome, String sobrenome, String email, String documento, String endereco, String complemento, String cidade, String telefone, String cep, Long paisId) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.paisId = paisId;
    }

    public String getDocumento() {
        return documento;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Cliente toModel(EntityManager em) {
        Cliente cliente = new Cliente(nome, sobrenome, email, documento, endereco, complemento, cidade, telefone, cep, em.find(Pais.class, paisId));
        if (em.createQuery("SELECT 1 FROM Estado WHERE pais_id = :value")
                .setParameter("value", paisId).getResultList().isEmpty())
            return cliente;
        cliente.setEstado(em.find(Estado.class, estadoId));
        return cliente;
    }

}
