package com.livraria.livraria.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Funcionarios extends Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private Date dataDeAdmissao;

    public Funcionarios() {
    }

    public Funcionarios(LocalDate dataNascimento, String nome, Date dataDeAdmissao, Long id) {
        super(dataNascimento, nome);
        this.dataDeAdmissao = dataDeAdmissao;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(Date dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }
}
