package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Livros;
import com.livraria.livraria.Services.HomeServices;
import com.livraria.livraria.Services.LivrosServices;
import com.livraria.livraria.dto.LivrosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeServices services;

    @GetMapping("/buscar/{query}")
    public List<LivrosDTO> buscarLivro(@PathVariable String query){
        return services.buscaGeneralizada(query);
    }
    @GetMapping
    public List<LivrosDTO> destaques(){
        return services.DestaquesDaHome();
    }

    @GetMapping("/{id}")
    public List<LivrosDTO> detalheDosDestaques(){
        return services.DetalhesDoDestaque();
    }

}
