package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Autores;
import com.livraria.livraria.Repository.AutoresRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresServices {

    private AutoresRepository autoresRepository;

    public AutoresServices(AutoresRepository autoresRepository) {
        this.autoresRepository = autoresRepository;
    }

    /*public AutoresDto adicionarAutor(AutoresDto autor) {
        var autorEntity = new Autores();
        autorEntity.setNome(autor.getNome());
        autorEntity.setAtivo(autor.isAtivo());
        return AutoresMapper.map(autoresRepository.save(autorEntity));
    }*/

    public void cadastrarAutores(Autores autores) {
        autoresRepository.save(autores);
    }

    public List<Autores> listarTodosAutores() {
        return autoresRepository.findAll();
    }

    public Optional<Autores> buscarPorId(long id) {
        return autoresRepository.findById(id);
    }

    public Autores atualizarAutor(Long id) {
        var autor = autoresRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Autor não encontrado"
                ));
        autor.setNome(autor.getNome());
        autor.setAtivo(autor.isAtivo());
        autoresRepository.save(autor);
        return autor;
    }

    public Optional<Autores> buscarPorNome(String nome) {
        return autoresRepository.findByNome(nome);
    }

    public void deletarAutor(Long id) {
        autoresRepository.deleteById(id);
    }

    public Autores inativarAutores(Long id) {
        var autor = autoresRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Autor não encontrado"
                ));

        autor.setAtivo(false);

        return autoresRepository.save(autor);
    }

    public Autores ativarAutores(Long id) {
        var autor = autoresRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Autor não encontrado"
                ));

        autor.setAtivo(true);

        return autoresRepository.save(autor);
    }

}