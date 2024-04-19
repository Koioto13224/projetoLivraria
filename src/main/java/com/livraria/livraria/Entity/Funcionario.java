package com.livraria.livraria.Entity;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Funcionario {
    private Long id;
    private Date dataDeAdmissao;
}
