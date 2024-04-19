package com.livraria.livraria.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String cep;
    @NotBlank
    private String rua;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String cidade;
}
