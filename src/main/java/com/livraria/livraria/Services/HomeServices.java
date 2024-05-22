package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Livros;
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
    EditorasRepository editorasRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<LivrosDTO> buscaGeneralizada(String query){
        Set<Livros> livros = new HashSet<>(livrosRepository.findByTituloContainingIgnoreCase(query));
        livros.addAll(livrosRepository.findByEditorasContainingIgnoreCase(query));
        livros.addAll(livrosRepository.findByAutoresContainingIgnoreCase(query));
        livros.addAll(livrosRepository.findByCategoriasContainingIgnoreCase(query));

        List<LivrosDTO> livrosDTO = new ArrayList<>();
        for (Livros livro:livros){
            LivrosDTO livrosDTOS =modelMapper.map(livro,LivrosDTO.class);
            livrosDTO.add(livrosDTOS);
        }
        return livrosDTO;
    }
}
