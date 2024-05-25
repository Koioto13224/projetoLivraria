package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoresRepository  extends JpaRepository<Autores,Long> {

    List<Autores> findByNomeContainingIgnoreCase(String nome);
}
