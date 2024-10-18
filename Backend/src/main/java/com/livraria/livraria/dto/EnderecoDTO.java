package com.livraria.livraria.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livraria.livraria.Entity.Clientes;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

public class EnderecoDTO {
    private Long id;
    private String cep;
    private String rua;
    private String logradouro;
    private String cidade;
    private Clientes clientes;


    public EnderecoDTO(String cep, String rua, String logradouro, String cidade) {
        this.cep = cep;
        this.rua = rua;
        this.logradouro = logradouro;
        this.cidade = cidade;
    }

    public EnderecoDTO() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
