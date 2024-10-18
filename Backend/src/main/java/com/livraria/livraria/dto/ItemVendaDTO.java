package com.livraria.livraria.dto;

import jakarta.validation.constraints.NotNull;

public class ItemVendaDTO {
    private LivrosDTO livros;
    private Double subTotal;
    private Integer qtdLivro;

    public ItemVendaDTO() {
    }

    public ItemVendaDTO(LivrosDTO livros, Integer qtdLivro, Double subTotal) {
        this.livros = livros;
        this.qtdLivro = qtdLivro;
        this.subTotal = subTotal;
    }

    public LivrosDTO getLivros() {
        return livros;
    }

    public void setLivros(LivrosDTO livros) {
        this.livros = livros;
    }

    public Integer getQtdLivro() {
        return qtdLivro;
    }

    public void setQtdLivro(Integer qtdLivro) {
        this.qtdLivro = qtdLivro;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

}
