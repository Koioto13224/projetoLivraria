package com.livraria.livraria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Clientes extends Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Enderecos enderecos;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    private boolean ativo;


    public Clientes() {
    }

    public Clientes(LocalDate dataNascimento, String nome, Enderecos enderecos,String email, String senha) {
        super(dataNascimento, nome);
        this.enderecos = enderecos;
        this.email = email;
        this.senha = senha;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}



