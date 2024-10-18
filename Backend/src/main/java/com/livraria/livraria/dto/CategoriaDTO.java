package com.livraria.livraria.dto;

import java.util.List;

public class CategoriaDTO {
    private Long id;
    private String nome;
    private List<LivrosDTO> livros;
    private boolean ativo;

    // Construtores
    public CategoriaDTO() {}

    public CategoriaDTO(String nome, boolean ativo,List<LivrosDTO> livros) {
        this.nome = nome;
        this.ativo = ativo;
        this.livros = livros;
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

    public List<LivrosDTO> getLivros() {
        return livros;
    }

    public void setLivros(List<LivrosDTO> livros) {
        this.livros = livros;
    }
}

