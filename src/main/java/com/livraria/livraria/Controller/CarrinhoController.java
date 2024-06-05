package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.*;
import com.livraria.livraria.Services.CarrinhoServices;
import com.livraria.livraria.dto.ClienteDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    CarrinhoServices services;

    @PostMapping("/adicionar/{id}")
    public void adicionar(@Valid @PathVariable Long id){
        services.adicionar(id);
    }

    @PostMapping("/aumentar/{id}")
    public void aumentarQuantidade(@PathVariable @Valid Long id){
        services.aumentarQuantidadeDeLivros(id);
    }

    @PostMapping("/diminuir/{id}")
    public void diminuirQuantidade(@PathVariable @Valid Long id){
        services.diminuirQuantidadeDeLivros(id);
    }

    @DeleteMapping("/removerLivro/{id}")
    public void removerLivro(@PathVariable @Valid Long id){
        services.removerLivroDoCarrinho(id);
    }

    @DeleteMapping("/removerTudo")
    public void removerTudo(){
        services.removerTodos();
    }

    @GetMapping("/mostrarCarrinho")
    public Carrinho listarCarrinho(){
        Carrinho carrinho = new Carrinho();
        ClienteDTO clienteDTO = new ClienteDTO();
        List<ItemVenda> itens = services.listarItensDoCarrinho();
        carrinho.setItemVendas(itens);
        carrinho.setTotal(services.calcularValorItens());
        carrinho.setIdClientes(clienteDTO.getId());
        return carrinho;
    }

    @PostMapping("/comprar")
    public Pedidos comprar(@RequestParam("clienteID") Long clienteId, @RequestParam("tipePagamento")TipoPagamento tipoPagamento){
        return services.comprar(clienteId,tipoPagamento);
    }

}
