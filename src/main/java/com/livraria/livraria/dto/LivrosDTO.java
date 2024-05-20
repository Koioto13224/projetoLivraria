package com.livraria.livraria.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livraria.livraria.Entity.Autores;
import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.Entity.Editoras;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


public class LivrosDTO {
    private Long id;
    private String titulo;
    private Long idautor;
    private Double preco;
    private boolean destaque;
    private String sumario;
    private Long idcategorias;
    private Long ideditora;
    private Integer estoque;

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public LivrosDTO() {
    }

    public LivrosDTO(boolean destaque, Integer estoque, Long id, Long idautor, Long idcategorias, Long ideditora, Double preco, String sumario, String titulo) {
        this.destaque = destaque;
        this.estoque = estoque;
        this.id = id;
        this.idautor = idautor;
        this.idcategorias = idcategorias;
        this.ideditora = ideditora;
        this.preco = preco;
        this.sumario = sumario;
        this.titulo = titulo;
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
    public Long getIdautor() {
        return idautor;
    }

    public void setIdautor(Long idautor) {
        this.idautor = idautor;
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

    public Long getIdcategorias() {
        return idcategorias;
    }

    public void setIdcategorias(Long idcategorias) {
        this.idcategorias = idcategorias;
    }

    public Long getIdeditora() {
        return ideditora;
    }

    public void setIdeditora(Long ideditora) {
        this.ideditora = ideditora;
    }
}
