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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HomeServices {

    @Autowired
    LivrosRepository livrosRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AutoresRepository autoresRepository;

    @Autowired
    CategoriasRepository categoriasRepository;

    @Autowired
    EditorasRepository editorasRepository;

    public List<LivrosDTO> buscaGeneralizada(String query){
        Set<Livros> livros = new HashSet<>(livrosRepository.findByTituloContainingIgnoreCase(query));

        livros.addAll(livrosRepository.findByAutores_NomeContainingIgnoreCase(query));
        livros.addAll(livrosRepository.findByCategorias_NomeContainingIgnoreCase(query));
        livros.addAll(livrosRepository.findByEditoras_NomeContainingIgnoreCase(query));


        List<LivrosDTO> livrosDTO = new ArrayList<>();
        for (Livros livro:livros){
            LivrosDTO livrosDTOS =modelMapper.map(livro,LivrosDTO.class);
            livrosDTOS.setNomeAutor(livro.getAutores().getNome());
            livrosDTOS.setNomeEditora(livro.getEditoras().getNome());
            livrosDTOS.setNomeCategoria(livro.getCategorias().getNome());
            livrosDTO.add(livrosDTOS);
        }
        return livrosDTO;
    }

    public List<LivrosDTO> DestaquesDaHome(){
        List<Livros> livrosEmDestaques = livrosRepository.findByDestaqueTrue();
        List<LivrosDTO> livrosDTO = new ArrayList<>();

        for (Livros livros:livrosEmDestaques){
            LivrosDTO livrosDTOS = new LivrosDTO();

            livrosDTOS.setId(livros.getId());
            livrosDTOS.setTitulo(livros.getTitulo());
            livrosDTOS.setPreco(livros.getPreco());
            livrosDTOS.setDestaque(livros.isDestaque());
            livrosDTO.add(livrosDTOS);
        }

        return livrosDTO;
    }

    public List<LivrosDTO> DetalhesDoDestaque() {
        List<Livros> livrosEmDestaques = livrosRepository.findByDestaqueTrue();
        List<LivrosDTO> livrosDTO = new ArrayList<>();

        for (Livros livros:livrosEmDestaques){
            LivrosDTO livrosDTOS = new LivrosDTO();

            livrosDTOS.setId(livros.getId());
            livrosDTOS.setTitulo(livros.getTitulo());
            livrosDTOS.setPreco(livros.getPreco());
            livrosDTOS.setNomeAutor(livros.getAutores().getNome());
            livrosDTOS.setSumario(livros.getSumario());
            livrosDTOS.setDestaque(livros.isDestaque());
            livrosDTO.add(livrosDTOS);
        }

        return livrosDTO;
    }
}

//public List<LivrosDTO> DestaquesDaHome(){
//    List<Livros> livrosEmDestaques = livrosRepository.findByDestaqueTrue();
//    List<LivrosDTO> livrosDTO = new ArrayList<>();
//
//    for(Livros livros:livrosEmDestaques){
//        LivrosDTO livrosDTOS = modelMapper.map(livros,LivrosDTO.class);
//        livrosDTOS.setNomeAutor(livros.getAutores().getNome());
//        livrosDTOS.setNomeEditora(livros.getEditoras().getNome());
//        livrosDTOS.setNomeCategoria(livros.getCategorias().getNome());
//        livrosDTO.add(livrosDTOS);
//    }
//    return livrosDTO;
//}

