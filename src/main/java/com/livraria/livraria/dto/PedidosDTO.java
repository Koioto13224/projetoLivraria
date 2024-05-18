package com.livraria.livraria.dto;

import com.livraria.livraria.Entity.Clientes;
import com.livraria.livraria.Entity.Livros;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class PedidosDTO {
    private Long id;
    @NotBlank
    private Clientes clientes;
    private List<Livros> itens;
    private boolean ativo;

    public PedidosDTO() {

    }

    public PedidosDTO(Long id, Clientes clientes, List<Livros> itens, boolean ativo) {
        this.id = id;
        this.clientes = clientes;
        this.itens = itens;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public List<Livros> getItens() {
        return itens;
    }

    public void setItens(List<Livros> itens) {
        this.itens = itens;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

