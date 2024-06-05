package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.*;
import com.livraria.livraria.Repository.LivrosRepository;
import com.livraria.livraria.Repository.PedidosRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosServices {

    @Autowired
    PedidosRepository pedidosRepository;
    @Autowired
    LivrosRepository livrosRepository;
    @Autowired
    @Lazy
    CarrinhoServices carrinhoServices;

    public List<Pedidos> listarTodosPedidos() {
        return pedidosRepository.findAll();
    }

    public Optional<Pedidos> buscarPedidoPorId(Long id) {
        return pedidosRepository.findById(id);
    }

    public Pedidos cadastrarPedidos(Pedidos pedidos) {
        pedidos.setAtivo(true);
        return pedidosRepository.save(pedidos);
    }

    public Pedidos atualizarPedidos(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    public void deletarPedidos(Long id) {
        pedidosRepository.deleteById(id);
    }

    public Pedidos finalizar(Long pedidoId, TipoPagamento tipoPagamento){

        Pedidos pedidos = pedidosRepository.findById(pedidoId).orElseThrow();
        List<ItemVenda> itens = carrinhoServices.listarItensDoCarrinho();

        if (itens.isEmpty()){throw new RuntimeException("Sem item");}

        for (ItemVenda itemVenda : itens) {
            Livros livro = livrosRepository.findById(itemVenda.getLivros().getId()).orElseThrow();
            if (livro.getEstoque() < itemVenda.getQtdLivro()) {
                throw new RuntimeException("Estoque insuficiente para o livro: " + livro.getTitulo());
            }
        }

        // Reduz o estoque dos livros
        for (ItemVenda itemVenda : itens) {
            Livros livro = livrosRepository.findById(itemVenda.getLivros().getId()).orElseThrow();
            livro.setEstoque(livro.getEstoque() - itemVenda.getQtdLivro());
            livrosRepository.save(livro);
        }

        pedidos.setPedidoStatus(PedidoStatus.CONCLUIDO);
        pedidos.setTipoPagamento(tipoPagamento);
        Pedidos pedidoSalvo = pedidosRepository.save(pedidos);
        carrinhoServices.removerTodos();
        return pedidoSalvo;
    }

}
