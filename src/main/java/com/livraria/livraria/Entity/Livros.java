package com.livraria.livraria.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Livros {
    @Id
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String autor;
    @NotBlank
    private String editora;
    @NotBlank
    private String capa;
    @NotBlank
    private Double preco;
    @NotBlank
    private boolean destaque;
    @NotBlank
    private String sumario;
}
