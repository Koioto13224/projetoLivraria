package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresRepository  extends JpaRepository<Autores,Long> {
}
