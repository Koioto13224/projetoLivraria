package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoresRepository  extends JpaRepository<Autores,Long> {
    List<Autores> findByNome(String nome);
}
