package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Livros;
import com.livraria.livraria.Services.LivrosServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivrosController {

    @Autowired
    private LivrosServices livrosServices;

    @GetMapping("/listarLivros")
    public List<Livros> listarLivros(){
        return livrosServices.listarTodosLivros();
    }

    @PostMapping("/adicionarLivro")
    public void adicionarLivro(@RequestBody @Valid Livros livros){
        livrosServices.cadastrarLivros(livros);
    }
}
