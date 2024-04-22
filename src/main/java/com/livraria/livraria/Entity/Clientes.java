package com.livraria.livraria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@Entity
public class Clientes extends Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    @OneToMany
    private List<Enderecos> enderecos;
    @NotBlank
    @OneToOne
    private Contas contas;

    public Clientes() {
    }

    public Clientes(Date dataNascimento, String nome, Contas contas, List<Enderecos> enderecos, Long id) {
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

    public List<Enderecos> getEndereco() {
        return enderecos;
    }

    public void setEndereco(List<Enderecos> enderecos) {
        this.enderecos = enderecos;
    }

    public Contas getConta() {
        return contas;
    }

    public void setConta(Contas contas) {
        this.contas = contas;
    }
}
