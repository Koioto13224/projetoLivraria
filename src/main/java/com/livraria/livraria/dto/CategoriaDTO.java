package com.livraria.livraria.dto;

public class CategoriaDTO {
    private Long id;
    private String nome;
    private boolean ativo;

    // Construtores
    public CategoriaDTO() {}

    public CategoriaDTO(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

