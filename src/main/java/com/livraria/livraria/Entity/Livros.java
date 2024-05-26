package com.livraria.livraria.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Autores autores;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Editoras editoras;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Categorias categorias;
    @NotNull
    private Double preco;
    @NotNull
    private boolean destaque;
    @NotBlank
    private String sumario;
    @NotNull
    private Integer estoque;


    public Livros() {
    }

    public Livros(Long id, String titulo, Autores autores, Editoras editoras, Categorias categorias, Double preco, boolean destaque, String sumario, List<Categorias> livros, Integer estoque) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.editoras = editoras;
        this.categorias = categorias;
        this.preco = preco;
        this.destaque = destaque;
        this.sumario = sumario;
        this.estoque = estoque;

    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public void setEditoras(Editoras editoras) {
        this.editoras = editoras;
    }

    public Autores getAutores() {
        return autores;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Editoras getEditoras() {
        return editoras;
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

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
