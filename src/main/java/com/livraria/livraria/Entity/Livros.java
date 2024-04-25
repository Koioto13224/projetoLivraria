package com.livraria.livraria.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Livros {
    @Id
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String autor;
    @NotBlank
    private String editora;
    @NotNull
    private Double preco;
    @NotNull
    private boolean destaque;
    @NotBlank
    private String sumario;
    private boolean estoque;
    public Livros() {
    }

    public Livros(Long id, String titulo, String autor, String editora, Double preco, boolean destaque, String sumario,boolean estoque) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.preco = preco;
        this.destaque = destaque;
        this.sumario = sumario;
        this.estoque = estoque;
    }

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public boolean isDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }
}
