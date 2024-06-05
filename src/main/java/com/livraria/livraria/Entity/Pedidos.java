package com.livraria.livraria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Clientes clientes;

//    @OneToMany(mappedBy = "pedidos",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @Transient
//    private List<ItemVenda> itens;

    private Double total;
    private boolean ativo;
    private PedidoStatus pedidoStatus;
    private TipoPagamento tipoPagamento;

    public Pedidos(Long id, Clientes clientes, boolean ativo,Double total,PedidoStatus pedidoStatus,TipoPagamento tipoPagamento) {
        this.id = id;
        this.clientes = clientes;

        this.total = total;
        this.pedidoStatus = pedidoStatus;
        this.tipoPagamento = tipoPagamento;
    }

    public Pedidos() {
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

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public PedidoStatus getPedidoStatus() {
        return pedidoStatus;
    }

    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
