package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.dto.CategoriaDTO;
import com.livraria.livraria.dto.LivrosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias,Long> {

    List<Categorias> findByNomeContainingIgnoreCase(String nome);
}
