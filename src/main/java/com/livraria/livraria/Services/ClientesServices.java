package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Clientes;
import com.livraria.livraria.Repository.ClientesRepository;
import com.livraria.livraria.dto.ClienteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesServices {

    ClientesRepository clientesRepository;
    ModelMapper modelMapper;

    public ClientesServices(ClientesRepository clientesRepository,ModelMapper modelMapper) {
        this.clientesRepository = clientesRepository;
        this.modelMapper = modelMapper;
    }

    public void cadastrarClientes(Clientes clientes) {
        clientesRepository.save(clientes);
    }

    public ClienteDTO buscarPeloIdClientes(Long id) {
        Clientes clientes = clientesRepository.findById(id).orElseThrow();
        ClienteDTO clienteDTO = modelMapper.map(clientes,ClienteDTO.class);

        clienteDTO.setEndereco(clientes.getEndereco());

        return clienteDTO;
    }

    public void deletarCliente(Long id) {
        clientesRepository.deleteById(id);
    }


    public List<Clientes> listarClientes() {
        List<Clientes> Cls = clientesRepository.findAll();
        return Cls;
    }

}