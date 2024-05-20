package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Autores;
import com.livraria.livraria.Entity.Livros;
import com.livraria.livraria.Repository.AutoresRepository;
import com.livraria.livraria.Repository.LivrosRepository;
import com.livraria.livraria.dto.AutoresDTO;
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
public class AutoresServices {

    private AutoresRepository autoresRepository;

    @Autowired
    LivrosRepository livrosRepository;

    @Autowired
    ModelMapper modelMapper;

    public AutoresServices(AutoresRepository autoresRepository) {
        this.autoresRepository = autoresRepository;
    }


    public void cadastrarAutores(Autores autores) {
        autoresRepository.save(autores);
    }

    public List<AutoresDTO> listarTodosAutores() {
        List<Autores> autores = autoresRepository.findAll();
        List<AutoresDTO> autoresDTOS = new ArrayList<>();

        for (Autores autor:autores){
            AutoresDTO autoresDTO = modelMapper.map(autor,AutoresDTO.class);

            List<LivrosDTO>  livrosDTOS = autoresDTO.getLivros();
            for (LivrosDTO livrosDTO: livrosDTOS){
                Livros livros = livrosRepository.findById(livrosDTO.getId()).orElse(null);
                if (livros != null) {
                    livrosDTO.setIdcategorias(livros.getCategorias().getId());
                    livrosDTO.setIdeditora(livros.getEditoras().getId());
                }
            }
            autoresDTOS.add(autoresDTO);
        }
        return autoresDTOS;
    }

    public AutoresDTO buscarPorId(Long id) {
        Optional<Autores> autoresOptional = autoresRepository.findById(id);

        if (autoresOptional.isPresent()) {
            Autores autor = autoresOptional.get();
            AutoresDTO autoresDTO = modelMapper.map(autor, AutoresDTO.class);

            List<LivrosDTO> livrosDTOS = new ArrayList<>();
            for (Livros livro : autor.getLivros()) {
                LivrosDTO livrosDTO = modelMapper.map(livro, LivrosDTO.class);
                livrosDTO.setIdcategorias(livro.getCategorias().getId());
                livrosDTO.setIdeditora(livro.getEditoras().getId());
                livrosDTOS.add(livrosDTO);
            }
            autoresDTO.setLivros(livrosDTOS);

            return autoresDTO;
        } else {
            throw new IllegalArgumentException("Autor não encontrado com o ID: " + id);
        }
    }


    public Autores atualizarAutor(Long id) {
        var autor = autoresRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Autor não encontrado"
                ));
        autor.setNome(autor.getNome());
        autor.setAtivo(autor.isAtivo());
        autoresRepository.save(autor);
        return autor;
    }

    public AutoresDTO buscarPorNome(String nome) {
        List<Autores> autores = autoresRepository.findByNome(nome);
        List<AutoresDTO> autoresDTOS = new ArrayList<>();


        AutoresDTO autoresDTO = null;
        for (Autores autor : autores) {
            autoresDTO = modelMapper.map(autor, AutoresDTO.class);

            List<LivrosDTO> livrosDTOS = autoresDTO.getLivros();
            for (LivrosDTO livrosDTO : livrosDTOS) {
                Livros livros = livrosRepository.findById(livrosDTO.getId()).orElse(null);
                if (livros != null) {
                    livrosDTO.setIdcategorias(livros.getCategorias().getId());
                    livrosDTO.setIdeditora(livros.getEditoras().getId());
                }
            }
            autoresDTOS.add(autoresDTO);
        }

        return autoresDTO;
    }



    public void deletarAutor(Long id) {
        autoresRepository.deleteById(id);
    }

    public Autores inativarAutores(Long id) {
        var autor = autoresRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Autor não encontrado"
                ));

        autor.setAtivo(false);

        return autoresRepository.save(autor);
    }

    public Autores ativarAutores(Long id) {
        var autor = autoresRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Autor não encontrado"
                ));

        autor.setAtivo(true);

        return autoresRepository.save(autor);
    }

}