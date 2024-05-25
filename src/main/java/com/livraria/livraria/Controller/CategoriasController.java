package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.Entity.Funcionarios;
import com.livraria.livraria.Services.CategoriasServices;
import com.livraria.livraria.dto.CategoriaDTO;
import com.livraria.livraria.dto.LivrosDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriasController {

    CategoriasServices categoriasServices;

    public CategoriasController(CategoriasServices categoriasServices) {
        this.categoriasServices = categoriasServices;
    }

    @GetMapping("/listarCategorias")
    public List<CategoriaDTO> listarCategorias() {
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

    @GetMapping("/buscarCategoria/{nome}")
    public CategoriaDTO buscarCategoria(@PathVariable String nome) {
        return categoriasServices.buscarPorCategoria(nome);
    }
}
