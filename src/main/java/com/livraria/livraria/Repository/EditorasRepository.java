package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Editoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorasRepository extends JpaRepository<Editoras,Long> {
}
