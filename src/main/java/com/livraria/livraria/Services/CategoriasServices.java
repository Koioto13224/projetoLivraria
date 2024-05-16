package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.Entity.Clientes;
import com.livraria.livraria.Entity.Enderecos;
import com.livraria.livraria.Repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoriasServices {
    @Autowired
    CategoriasRepository categoriasRepository;

    public List<Categorias> listarCategorias() {
        List<Categorias> Cat = categoriasRepository.findAll();
        return Cat;
    }

    public void criarCategorias(Categorias categorias) {
        categoriasRepository.save(categorias);
    }

    public Categorias inativarCategorias(Long id) {
        var categorias = categoriasRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Categoria não encontrado"
                ));

        categorias.setAtivo(false);

        return categoriasRepository.save(categorias);
    }
    public Categorias ativarCategorias(Long id) {
        var categorias = categoriasRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Categoria não encontrado"
                ));

        categorias.setAtivo(true);

        return categoriasRepository.save(categorias);
    }
    public Categorias AtualizarCategorias(Categorias categorias) {
        return categoriasRepository.save(categorias);
    }
}
