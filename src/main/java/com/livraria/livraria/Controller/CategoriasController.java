package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.Entity.Funcionarios;
import com.livraria.livraria.Services.CategoriasServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriasController {

    CategoriasServices categoriasServices;

    public CategoriasController(CategoriasServices categoriasServices) {
        this.categoriasServices = categoriasServices;
    }

    @GetMapping("/listarCategorias")
    public List<Categorias> listarCategorias() {
        return categoriasServices.listarCategorias();
    }

    @PostMapping("/criarCategorias")
    public void criarCategorias(@RequestBody @Valid Categorias categorias) {
        categoriasServices.criarCategorias(categorias);
    }

    @PutMapping("/inativar/{id}")
    public void inativarCategoria(@PathVariable Long id) {
        categoriasServices.inativarCategorias(id);
    }
    @PutMapping("/ativar/{id}/")
    public void ativarCategoria(@PathVariable Long id) {
        categoriasServices.ativarCategorias(id);
    }
    @PutMapping("/editarCategorias")
    public Categorias AtualizarCategorias(@RequestBody Categorias categorias) {
        return categoriasServices.AtualizarCategorias(categorias);
    }
}
