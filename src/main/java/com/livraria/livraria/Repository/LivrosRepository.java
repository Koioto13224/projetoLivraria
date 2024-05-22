package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivrosRepository extends JpaRepository<Livros,Long> {

    List<Livros> findByTituloContainingIgnoreCase(String query);

    @Query("SELECT l FROM Livros l JOIN l.categorias c WHERE LOWER(c.nome) LIKE LOWER(concat('%', :autorNome, '%'))")
    List<Livros> findByAutoresContainingIgnoreCase(@Param("autorNome") String query);

    @Query("SELECT l FROM Livros l JOIN l.categorias c WHERE LOWER(c.nome) LIKE LOWER(concat('%', :categoriaNome, '%'))")
    List<Livros> findByCategoriasContainingIgnoreCase(@Param("categoriaNome") String query);

    @Query("SELECT l FROM Livros l JOIN l.categorias c WHERE LOWER(c.nome) LIKE LOWER(concat('%', :editoraNome, '%'))")
    List<Livros> findByEditorasContainingIgnoreCase(@Param("editoraNome") String query);

}