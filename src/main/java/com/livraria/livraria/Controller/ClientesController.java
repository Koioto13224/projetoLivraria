package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Clientes;
import com.livraria.livraria.Services.ClientesServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientesController {

    ClientesServices clientesServices;

    public ClientesController(ClientesServices clientesServices) {
        this.clientesServices = clientesServices;
    }

    @PostMapping("/cadastrarClientes")
    public void cadastrarClientes(@Valid @RequestBody Clientes clientes) {
        clientesServices.cadastrarClientes(clientes);
    }

    @DeleteMapping("/deletarCliente/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clientesServices.deletarCliente(id);
    }

    @PutMapping("/editarClientes/{id}")
    public Clientes editarClientes(@PathVariable  Clientes clientes) {
        return clientesServices.AtualizarClientes(clientes);
    }

    @GetMapping("/listarClientes")
    public List<Clientes> listarClientes() {
        return clientesServices.listarClientes();
    }

    @GetMapping("/buscarClientesId/{id}")
    public Optional<Clientes> buscarPeloClientes(@PathVariable long id) {
        return clientesServices.buscarPeloIdClientes(id);
    }

}
