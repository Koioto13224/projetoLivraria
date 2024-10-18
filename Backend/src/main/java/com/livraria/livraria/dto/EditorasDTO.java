package com.livraria.livraria.dto;

import java.util.List;

public class EditorasDTO {
    private Long id;
    private String nome;
    private List<LivrosDTO> livros;

    public EditorasDTO() {
    }

    public EditorasDTO(Long id, String nome, List<LivrosDTO> livros) {
        this.id = id;
        this.nome = nome;
        this.livros = livros;
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
}
