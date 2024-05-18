package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Clientes;
import com.livraria.livraria.Repository.ClientesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesServices {

    private ClientesRepository clientesRepository;

    public ClientesServices(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    public void cadastrarClientes(Clientes clientes) {
        clientesRepository.save(clientes);
    }

    public Optional<Clientes> buscarPeloIdClientes(Long id) {
        return clientesRepository.findById(id);
    }

    public void deletarCliente(Long id) {
        clientesRepository.deleteById(id);
    }

   /* public Clientes editarClientes(Clientes clientes) {
        return clientesRepository.save(clientes);
    }*/

    public List<Clientes> listarClientes() {
        List<Clientes> Cls = clientesRepository.findAll();
        return Cls;
    }
    public Clientes AtualizarClientes (Clientes clientes) {
        return clientesRepository.save(clientes);
    }
    /*public Clientes atualizarClientes(Long id, Clientes clientes) {
        var cliente = clientesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Cliente não encontrado"
                ));
        cliente.setNome(cliente.getNome());
        cliente.setAtivo(cliente.isAtivo());
        clientesRepository.save(clientes);
        return clientes;
    }*/

    public Clientes inativarClientes(Long id) {
        var clientes = clientesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Autor não encontrado"
                ));

        clientes.setAtivo(false);

        return clientesRepository.save(clientes);
    }
}