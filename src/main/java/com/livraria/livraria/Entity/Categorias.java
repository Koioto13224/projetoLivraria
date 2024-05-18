package com.livraria.livraria.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    @JsonProperty
    private boolean ativo;
    @NotNull
    @OneToMany
    private List<Livros> livros;

    public Categorias() {
    }

    public Categorias(boolean ativo, String nome) {
        this.ativo = ativo;
        this.nome = nome;
    }
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
