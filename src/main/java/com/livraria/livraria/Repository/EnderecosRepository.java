package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecosRepository extends JpaRepository<Enderecos,Long> {
}
