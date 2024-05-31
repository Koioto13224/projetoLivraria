package com.livraria.livraria.Entity;

import java.util.List;

public class Carrinho {

    private Clientes clientes;
    private List<ItemVenda> itemVendas;
    private Double total;

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
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
