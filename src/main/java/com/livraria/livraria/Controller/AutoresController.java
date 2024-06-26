package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Autores;
import com.livraria.livraria.Services.AutoresServices;
import com.livraria.livraria.dto.AutoresDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutoresController {

    AutoresServices autoresServices;

    public AutoresController(AutoresServices autoresServices) {
        this.autoresServices = autoresServices;
    }

    @PostMapping("/cadastrarAutores")
    public void cadastrarAutores(@Valid @RequestBody Autores autores) {
        autoresServices.cadastrarAutores(autores);
    }

    @GetMapping("/listarTodosAutores")
    public List<AutoresDTO> listarAutores() {
        return autoresServices.listarTodosAutores();
    }

    @GetMapping("/buscarPorId/{id}")
    public AutoresDTO buscarPorId(@PathVariable Long id) {
        return autoresServices.buscarPorId(id);
    }

    @GetMapping("/buscarPorNome/{nome}")
    public AutoresDTO buscarPorNome(@PathVariable String nome) {
        return autoresServices.buscarPorNome(nome);
    }

    @PutMapping("editarAutor/{id}")
    public Autores editarAutores(@PathVariable Long id) {
        return autoresServices.atualizarAutor(id);
    }

    @DeleteMapping("/deletarAutor/{id}")
    public void deletar(@PathVariable Long id) {
        autoresServices.deletarAutor(id);
    }

}
