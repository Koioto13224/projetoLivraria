package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<Livros,Long> {
}
