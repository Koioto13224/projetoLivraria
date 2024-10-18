package com.livraria.livraria.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Funcionarios extends Pessoas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeAdmissao;

    public Funcionarios() {
    }

    public Funcionarios(LocalDate dataNascimento, String nome, LocalDate dataDeAdmissao) {
        super(dataNascimento, nome);
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }


}
