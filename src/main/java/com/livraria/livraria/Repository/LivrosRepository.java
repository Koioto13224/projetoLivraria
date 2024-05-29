package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Livros;
import com.livraria.livraria.dto.LivrosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface LivrosRepository extends JpaRepository<Livros,Long> {

    List<Livros> findByTituloContainingIgnoreCase(String titulo);
    List<Livros> findByEditorasNomeContainingIgnoreCase(String nome);
    List<Livros> findByAutoresNomeContainingIgnoreCase(String nome);
    List<Livros> findByCategoriasNomeContainingIgnoreCase(String nome);
    List<Livros> findByDestaqueTrue();

    List<Livros> findByAutores_NomeContainingIgnoreCase(String query);

    List<Livros> findByCategorias_NomeContainingIgnoreCase(String query);

    List<Livros> findByEditoras_NomeContainingIgnoreCase(String query);
}