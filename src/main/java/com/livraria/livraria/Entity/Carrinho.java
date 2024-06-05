package com.livraria.livraria.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Carrinho {

    private Long clientes;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "carrinho",fetch = FetchType.EAGER)
    private List<ItemVenda> itemVendas;
    private Double total;

    public Long getClientes() {
        return clientes;
    }

    public void setIdClientes(Long clientes) {
        this.clientes = clientes;
    }

    public List<ItemVenda> getItemVendas() {
        return itemVendas;
    }

    public void setItemVendas(List<ItemVenda> itemVendas) {
        this.itemVendas = itemVendas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
