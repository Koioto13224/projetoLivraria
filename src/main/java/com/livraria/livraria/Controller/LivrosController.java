package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.Entity.Livros;
import com.livraria.livraria.Services.LivrosServices;
import com.livraria.livraria.dto.AutoresDTO;
import com.livraria.livraria.dto.LivrosDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivrosController {

    LivrosServices livrosServices;

    public LivrosController(LivrosServices livrosServices) {
        this.livrosServices = livrosServices;
    }

    @PostMapping("/cadastrarLivros")
    public void cadastrarLivros(@Valid @RequestBody LivrosDTO livros) {
        livrosServices.cadastrarLivros(livros);
    }

    @GetMapping("/listarLivros")
    public List<LivrosDTO> listarLivros() {
        return livrosServices.listarTodosLivros();
    }

    @GetMapping("/buscarLivroPorId/{id}")
    public LivrosDTO buscarLivro(@PathVariable @Valid Long id) {
        return livrosServices.buscarPorId(id);
    }

    @GetMapping("/buscarPorTitulo/{titulo}")
    public List<LivrosDTO> buscarLivro(@PathVariable @Valid String titulo) {
        return livrosServices.buscarPorTitulo(titulo);
    }

}
