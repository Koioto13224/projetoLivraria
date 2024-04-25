package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.Repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasServices {

    private Categorias categorias;
    @Autowired
    CategoriasRepository categoriasRepository;

    public List<Categorias> listarCategoias(){
        return categoriasRepository.findAll();
    }

    public void criarCategorias(Categorias categorias){
        categoriasRepository.save(categorias);
    }

    public void ativar(boolean ativo){
        categorias.setAtivo(ativo);
    }

}
