package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Pedidos;
import com.livraria.livraria.Entity.TipoPagamento;
import com.livraria.livraria.Services.PedidosServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PedidosController {

    PedidosServices pedidosServices;

    public PedidosController(PedidosServices pedidosServices) {
        this.pedidosServices = pedidosServices;
    }

    @GetMapping("/listarpedidos")
    public List<Pedidos> listarTodosPedidos() {
        return pedidosServices.listarTodosPedidos();
    }

    @GetMapping("buscarPedidoPorId/{id}")
    public Optional<Pedidos> buscarPorId(@PathVariable Long id) {
        return pedidosServices.buscarPedidoPorId(id);
    }

    @PostMapping("/finalizar")
    public Pedidos finalizarPedido(@RequestParam("pedidoId") Long pedidoId, @RequestParam("tipoPagamento") TipoPagamento tipoPagamento) {
        return pedidosServices.finalizar(pedidoId, tipoPagamento);
    }
}
