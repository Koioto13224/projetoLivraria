package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.*;
import com.livraria.livraria.Repository.CategoriasRepository;
import com.livraria.livraria.Repository.LivrosRepository;
import com.livraria.livraria.dto.AutoresDTO;
import com.livraria.livraria.dto.CategoriaDTO;
import com.livraria.livraria.dto.LivrosDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriasServices {
    @Autowired
    CategoriasRepository categoriasRepository;
    @Autowired
    LivrosRepository livrosRepository;
    @Autowired
    ModelMapper modelMapper;

    public List<CategoriaDTO> listarCategorias() {
        List<Categorias> categorias = categoriasRepository.findAll();
        List<CategoriaDTO> categoriaDTOS = new ArrayList<>();

        for (Categorias categoria:categorias){
            CategoriaDTO categoriaDTO = modelMapper.map(categoria,CategoriaDTO.class);

            categoriaDTOS.add(categoriaDTO);
        }
        return categoriaDTOS;
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

    public Optional<CategoriaDTO> buscarPorCategoria(String nome) {
        List<Categorias> categoria = categoriasRepository.findByNome(nome);
        List<CategoriaDTO> categoriaDTOS = new ArrayList<>();


        CategoriaDTO categoriaDTO = null;
        for (Categorias categorias : categoria) {
            categoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);

            List<LivrosDTO> livrosDTOS = categoriaDTO.getLivros();
            for (LivrosDTO livrosDTO : livrosDTOS) {
                Livros livros = livrosRepository.findById(livrosDTO.getId()).orElse(null);
                if (livros != null) {
                    livrosDTO.setIdcategorias(livros.getCategorias().getId());
                    livrosDTO.setIdeditora(livros.getEditoras().getId());
                    livrosDTO.setIdautor(livros.getAutores().getId());
                }
            }
            categoriaDTOS.add(categoriaDTO);
        }

        return Optional.of(categoriaDTO);
    }
}
