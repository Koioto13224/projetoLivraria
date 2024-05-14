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
    @OneToOne
    private Autores autores;
    @NotNull
    @OneToOne
    private Editoras editoras;
    @NotNull
    @OneToOne
    private Categorias categorias;
    @NotNull
    private Double preco;
    @NotNull
    private boolean destaques;
    @NotBlank
    private String sumario;
    private Integer estoque;

//    @OneToMany(mappedBy = "livros")
//    private ListCategorias categoria;

    public Livros() {
    }

    public Livros(Long id, String titulo, Autores autores, Editoras editoras, Categorias categorias, Double preco, boolean destaques, String sumario, List<Categorias> livros, Integer estoque) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.editoras = editoras;
        this.categorias = categorias;
        this.preco = preco;
        this.destaques = destaques;
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

    public boolean isDestaques() {
        return destaques;
    }

    public void setDestaques(boolean destaque) {
        this.destaques = destaque;
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
