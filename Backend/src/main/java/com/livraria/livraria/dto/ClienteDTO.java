package com.livraria.livraria.dto;

import com.livraria.livraria.Entity.Enderecos;
import com.livraria.livraria.Entity.Pessoas;

import java.time.LocalDate;

public class ClienteDTO  extends Pessoas {
    private Long id;
    private Enderecos enderecos;
    private String email;
    private String senha;

    public ClienteDTO() {
    }

    public ClienteDTO(LocalDate dataNascimento, String nome, Enderecos enderecos, String email, String senha) {
        super(dataNascimento, nome);
        this.enderecos = enderecos;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enderecos getEndereco() {
        return enderecos;
    }

    public void setEndereco(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
