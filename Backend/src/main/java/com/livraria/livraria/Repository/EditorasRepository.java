package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Editoras;
import com.livraria.livraria.dto.EditorasDTO;
import com.livraria.livraria.dto.LivrosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EditorasRepository extends JpaRepository<Editoras,Long> {

    List<Editoras> findByNomeContainingIgnoreCase(String nome);
}
