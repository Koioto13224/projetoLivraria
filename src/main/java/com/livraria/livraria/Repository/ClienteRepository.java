package com.livraria.livraria.Repository;

import com.livraria.livraria.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes,Long> {
}
