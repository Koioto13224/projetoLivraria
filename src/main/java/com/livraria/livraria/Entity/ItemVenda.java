package com.livraria.livraria.Entity;

import com.livraria.livraria.dto.LivrosDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Livros livros;
    @NotNull
    private Double subTotal;
    @NotNull
    private Integer qtdLivro;

    public Livros getLivros() {
        return livros;
    }

    public void setLivros(Livros livros) {
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
