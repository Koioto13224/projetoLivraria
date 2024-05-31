package com.livraria.livraria.Entity;

import com.livraria.livraria.dto.LivrosDTO;

public class ItemVenda {

    private LivrosDTO livros;
    private Double subTotal;
    private Integer qtdLivro;

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
