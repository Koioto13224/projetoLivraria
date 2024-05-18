package com.livraria.livraria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Enderecos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String cep;
    @NotNull
    private String rua;
    @NotNull
    private String logradouro;
    @NotNull
    private String cidade;

    @OneToOne
    private Clientes clientes;


    public Enderecos(String cep, String rua, String logradouro, String cidade) {
        this.cep = cep;
        this.rua = rua;
        this.logradouro = logradouro;
        this.cidade = cidade;
    }

    public Enderecos() {
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
}
