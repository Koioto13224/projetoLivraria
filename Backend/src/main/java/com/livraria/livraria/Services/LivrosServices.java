package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Autores;
import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.Entity.Editoras;
import com.livraria.livraria.Entity.Livros;
import com.livraria.livraria.Repository.AutoresRepository;
import com.livraria.livraria.Repository.CategoriasRepository;
import com.livraria.livraria.Repository.EditorasRepository;
import com.livraria.livraria.Repository.LivrosRepository;
import com.livraria.livraria.dto.AutoresDTO;
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
        livros.setImagem(livrosDTO.getImagem());
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
            livrosDTO.setNomeCategoria(livro.getCategorias().getNome());
            livrosDTO.setNomeEditora(livro.getEditoras().getNome());
            livrosDTO.setNomeAutor(livro.getAutores().getNome());

            livrosDTOS.add(livrosDTO);
        }
        return livrosDTOS;
    }

    public LivrosDTO buscarPorId(long id) {
        Livros livro = livrosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado com o ID: " + id));

        LivrosDTO livrosDTO = modelMapper.map(livro, LivrosDTO.class);
        livrosDTO.setNomeCategoria(livro.getCategorias().getNome());
        livrosDTO.setNomeEditora(livro.getEditoras().getNome());
        livrosDTO.setNomeAutor(livro.getAutores().getNome());

        return livrosDTO;
    }

    public Livros editarLivros(Livros livros) {
        return livrosRepository.save(livros);
    }

    public List<LivrosDTO> buscarPorTitulo(String titulo) {
        List<Livros> livros = livrosRepository.findByTituloContainingIgnoreCase(titulo);
        List<LivrosDTO> livrosDTOS = new ArrayList<>();

            for(Livros livro:livros) {
                LivrosDTO livrosDTO = modelMapper.map(livro, LivrosDTO.class);
                livrosDTO.setNomeCategoria(livro.getCategorias().getNome());
                livrosDTO.setNomeEditora(livro.getEditoras().getNome());
                livrosDTO.setNomeAutor(livro.getAutores().getNome());

                livrosDTOS.add(livrosDTO);

            }
            return livrosDTOS;
    }



}