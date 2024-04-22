package com.livraria.livraria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    @OneToOne
    private Clientes clientes;
    @OneToMany
    private List<Livros> itens;
}
