package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.Services.CategoriasServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriasController {

    @Autowired
    private CategoriasServices categoriasServices;

    @GetMapping("/listarCategorias")
    public List<Categorias> listarCategorias() {
            return categoriasServices.listarCategoias();
    }

    @PostMapping("/criarCategorias")
    public void criarCategorias(@RequestBody @Valid Categorias categorias){
        categoriasServices.criarCategorias(categorias);
    }
}
