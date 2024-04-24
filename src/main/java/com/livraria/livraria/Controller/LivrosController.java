package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Clientes;
import com.livraria.livraria.Entity.Livros;
import com.livraria.livraria.Services.LivrosServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class   LivrosController {

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

    @GetMapping("/buscarLivro/{id}")
    public Optional<Livros> buscarLivro(@PathVariable @Valid Long id){
       return livrosServices.buscarLivro(id);
    }

    @PutMapping("/editarLivro")
    public Livros editar(@RequestBody Livros livros) {
        return livrosServices.editar(livros);
    }

    @PutMapping("/ativar/{id}")
    public void ativar(@RequestBody @PathVariable Livros livros){
        livrosServices.ativarLivro(livros);
    }
}
