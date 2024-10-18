package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.*;
import com.livraria.livraria.Repository.ClientesRepository;
import com.livraria.livraria.Repository.LivrosRepository;
import com.livraria.livraria.Repository.PedidosRepository;
import com.livraria.livraria.dto.LivrosDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrinhoServices {

    @Autowired
    LivrosRepository livrosRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ClientesRepository clientesRepository;
    @Autowired
    PedidosRepository pedidosRepository;
    @Autowired
    PedidosServices pedidosServices;

    private List<ItemVenda> item = new ArrayList<>();

    public void adicionar(Long id){
        Livros livros = livrosRepository.findById(id).orElseThrow();
        LivrosDTO livrosDTO = modelMapper.map(livros,LivrosDTO.class);

        for (ItemVenda itens: item){
            if (itens.getLivros().getId().equals(livrosDTO.getId())){
                itens.setQtdLivro(itens.getQtdLivro() + 1);
                itens.setSubTotal(itens.getQtdLivro() * livrosDTO.getPreco());
                return;
            }
        }

        ItemVenda itemVenda = new ItemVenda();

        itemVenda.setLivros(livros);
        itemVenda.setQtdLivro(1);
        itemVenda.getLivros();
        itemVenda.setSubTotal(livrosDTO.getPreco());

        item.add(itemVenda);


    }

    public void removerLivroDoCarrinho(Long id) {
        for (int i = 0; i < item.size(); i++) {

            ItemVenda itens = item.get(i);
            if (itens.getLivros().getId().equals(id)) {

                if (itens.getQtdLivro() > 1) {
                    itens.setQtdLivro(itens.getQtdLivro() - 1);
                    itens.setSubTotal(itens.getQtdLivro() * itens.getLivros().getPreco());
                }

                else {
                    item.remove(i);
                }
                calcularValorItens();
                break;
            }

        }
    }

    public void removerTodos() {
        item.clear();
        calcularValorItens();
    }

    public double calcularValorItens() {
        double valorItens = 0.0;

        for (ItemVenda itens : item) {
            valorItens += itens.getQtdLivro() * itens.getLivros().getPreco();
        }

        return valorItens;
    }

    public void aumentarQuantidadeDeLivros(Long id) {
        for (ItemVenda itens : item) {

            if (itens.getLivros().getId().equals(id)) {
                itens.setQtdLivro(itens.getQtdLivro() + 1);
                calcularValorItens();
                return;
            }

        }
    }

    public void diminuirQuantidadeDeLivros(Long id) {
        for (ItemVenda itens : item) {

            if (itens.getLivros().getId().equals(id)) {

                if (itens.getQtdLivro() > 1) {
                    itens.setQtdLivro(itens.getQtdLivro() - 1);
                }

                calcularValorItens();
                return;
            }

        }
    }

    public List<ItemVenda> listarItensDoCarrinho() {
        return item;
    }

    public Pedidos comprar(Long clienteId,TipoPagamento tipoPagamento) {

        Clientes cliente = clientesRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedidos pedido = new Pedidos();
        pedido.setClientes(cliente);
        pedido.setItens(new ArrayList<>());
        pedido.setTotal(calcularValorItens());
        pedido.setPedidoStatus(PedidoStatus.PROCESSANDO);

        for (ItemVenda itemVenda: item){
            itemVenda.setPedidos(pedido);
        }

        Pedidos salvo =pedidosRepository.save(pedido);

        return salvo;
    }

}
