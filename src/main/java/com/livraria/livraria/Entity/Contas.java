package com.livraria.livraria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Contas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    @OneToOne
    private Clientes clientes;
}
