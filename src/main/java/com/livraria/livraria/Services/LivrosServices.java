package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Autores;
import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.Entity.Editoras;
import com.livraria.livraria.Entity.Livros;
import com.livraria.livraria.Repository.AutoresRepository;
import com.livraria.livraria.Repository.CategoriasRepository;
import com.livraria.livraria.Repository.EditorasRepository;
import com.livraria.livraria.Repository.LivrosRepository;
import com.livraria.livraria.dto.LivrosDTO;
import jakarta.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivrosServices {

    @Autowired
    LivrosRepository livrosRepository;
    @Autowired
    AutoresRepository autoresRepository;
    @Autowired
    EditorasRepository editorasRepository;
    @Autowired
    CategoriasRepository categoriasRepository;
    @Autowired
    ModelMapper modelMapper;

    Livros livros;

    public LivrosServices(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public void cadastrarLivros( LivrosDTO livrosDTO) {
        Autores autores = autoresRepository.findById(livrosDTO.getIdautor())
                .orElseThrow(() -> new IllegalArgumentException("Autor não encontrado com o ID: " + livrosDTO.getIdautor()));

        Editoras editoras = editorasRepository.findById(livrosDTO.getIdeditora())
                .orElseThrow(() -> new IllegalArgumentException("Editora não encontrada com o ID: " + livrosDTO.getIdeditora()));

        Categorias categorias = categoriasRepository.findById(livrosDTO.getIdcategorias()).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada com ID:" + livrosDTO.getIdeditora()));

        Livros livros = converterPraEntidade(livrosDTO);
        livros.setAutores(autores);
        livros.setEditoras(editoras);
        livros.setCategorias(categorias);
        livrosRepository.save(livros);

    }

    private Livros converterPraEntidade(LivrosDTO livrosDTO){
        return modelMapper.map(livrosDTO,Livros.class);
    }


    public List<LivrosDTO> listarTodosLivros() {
        List<Livros> livros = livrosRepository.findAll();
        List<LivrosDTO> livrosDTOS = new ArrayList<>();

        for (Livros livro:livros){
            LivrosDTO livrosDTO = modelMapper.map(livro,LivrosDTO.class);
            livrosDTO.setIdcategorias(livro.getCategorias().getId());
            livrosDTO.setIdeditora(livro.getEditoras().getId());
            livrosDTO.setIdautor(livro.getAutores().getId());

            livrosDTOS.add(livrosDTO);
        }
        return livrosDTOS;
    }

    public Optional<Livros> buscarPorId(long id) {
        return livrosRepository.findById(id);
    }

    public Livros editarLivros(Livros livros) {
        return livrosRepository.save(livros);
    }

    public Optional<Livros> buscarPorTitulo(String titulo) {
        return livrosRepository.findByTitulo(titulo);
    }

    public Optional<Livros> buscarPorCategoria(Categorias categorias) {
        return livrosRepository.findByCategorias(categorias);
    }
//mexer dps
//    public List<Livros> destaque() {
//            return livrosRepository.findByDestaque();
//    }

    public Livros atualizarLivros(Livros livros) {
        return livrosRepository.save(livros);
    }

   /* public List<Livros> destacarLivrosPorAno(int ano) {
        return livrosRepository.findAllByAno(ano);*/
}