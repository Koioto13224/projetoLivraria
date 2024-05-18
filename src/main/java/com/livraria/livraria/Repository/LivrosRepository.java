package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Autores;
import com.livraria.livraria.Entity.Categorias;
import com.livraria.livraria.Entity.Editoras;
import com.livraria.livraria.Entity.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivrosRepository extends JpaRepository<Livros,Long> {
    Optional<Livros> findByTitulo(String titulo);

    Optional<Livros> findByCategorias(Categorias categoria);

    List<Livros> findByAutores(Autores autor);

    List<Livros> findByEditoras(Editoras editoras);
}