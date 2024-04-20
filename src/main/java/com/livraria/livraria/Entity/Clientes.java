package com.livraria.livraria.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
public class Clientes extends Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private Enderecos enderecos;
    @NotBlank
    private Contas contas;

    public Clientes(Date dataNascimento, String nome) {
        super(dataNascimento, nome);
    }

    public Clientes(Date dataNascimento, String nome, Contas contas, Enderecos enderecos, Long id) {
        super(dataNascimento, nome);
        this.contas = contas;
        this.enderecos = enderecos;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enderecos getEndereco() {
        return enderecos;
    }

    public void setEndereco(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

    public Contas getConta() {
        return contas;
    }

    public void setConta(Contas contas) {
        this.contas = contas;
    }
}
