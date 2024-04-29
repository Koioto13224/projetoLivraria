package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Autores;
import com.livraria.livraria.Entity.Enderecos;
import com.livraria.livraria.Repository.AutoresRepository;
import com.livraria.livraria.Repository.EnderecosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecosServices {

    @Autowired
    EnderecosRepository enderecosRepository;

    Enderecos enderecos;


    public Enderecos editar(Enderecos enderecos){
        return enderecosRepository.save(enderecos);
    }

    public void deletarEndereco(Long id){
        enderecosRepository.deleteById(id);
    }
}
