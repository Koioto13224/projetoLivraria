package com.livraria.livraria.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private boolean ativo;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
