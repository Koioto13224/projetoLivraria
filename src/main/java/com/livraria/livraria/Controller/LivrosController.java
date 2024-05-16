package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.Entity.Livros;
import com.livraria.livraria.Services.LivrosServices;
import com.livraria.livraria.dto.LivrosDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<Livros> listarLivros() {
        return livrosServices.listarTodosLivros();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Livros> buscarLivro(@PathVariable @Valid Long id) {
        return livrosServices.buscarPorId(id);
    }

    @GetMapping("/buscar/{titulo}")
    public Optional<Livros> buscarLivro(@PathVariable @Valid String titulo) {
        return livrosServices.buscarPorTitulo(titulo);
    }

   /* @PutMapping("/editarLivro/{id}")
    public Livros editarLivros (@RequestBody @PathVariable Livros livros) {
        return livrosServices.editarLivros(livros);
    }*/

    public List <Livros> destaque() {
        return livrosServices.destaque();
    }

    @GetMapping("/buscarCategoria/{categorias}")
    public Optional<Livros> buscarCategoria(@PathVariable Categorias categorias) {
        return livrosServices.buscarPorCategoria(categorias);
    }

    @PutMapping("/atualizarLivros/{id}")
    public ResponseEntity<Void> atualizarLivros(@PathVariable Long id, @RequestBody Livros livros) {
        livros.setId(id);
        livrosServices.atualizarLivros(livros);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
