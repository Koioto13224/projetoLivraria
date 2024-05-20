package com.livraria.livraria.dto;


import java.util.List;


public class AutoresDTO {

    private Long id;
    private String nome;
    private List<LivrosDTO> livros;
    private boolean ativo;

    public AutoresDTO(Long id, String nome, boolean ativo,List<LivrosDTO> livros) {
        this.id = id;
        this.nome = nome;
        this.livros = livros;
        this.ativo = ativo;
    }

    public AutoresDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LivrosDTO> getLivros() {
        return livros;
    }

    public void setLivros(List<LivrosDTO> livros) {
        this.livros = livros;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}