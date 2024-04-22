package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Livros;
import com.livraria.livraria.Repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosServices {

    @Autowired
    private LivrosRepository livrosRepository;

    public LivrosServices(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public void cadastrarLivros(Livros livros){
        livrosRepository.save(livros);
    }

    public List<Livros> listarTodosLivros(){
        return livrosRepository.findAll();
    }
}
