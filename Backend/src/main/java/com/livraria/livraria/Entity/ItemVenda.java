package com.livraria.livraria.Entity;

import com.livraria.livraria.dto.LivrosDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

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
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Pedidos pedidos;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
}
