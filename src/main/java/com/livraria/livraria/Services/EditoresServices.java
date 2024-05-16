package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Editoras;
import com.livraria.livraria.Repository.EditorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoresServices {

    private EditorasRepository editorasRepository;

    public EditoresServices(EditorasRepository editorasRepository) {
        this.editorasRepository = editorasRepository;
    }

    public void cadastrarEditoras(Editoras editoras) {
        editorasRepository.save(editoras);
    }

    public List<Editoras> listarTodosEditoras() {
        return editorasRepository.findAll();
    }

    public Optional<Editoras> buscarPorId(long id) {
        return editorasRepository.findById(id);
    }

    public Editoras AtualizarEditoras (Editoras editoras) {
        return editorasRepository.save(editoras);
    }

    public Optional<Editoras> buscarPorEditora(String nome) {
        return editorasRepository.findByNome(nome);
    }

    public void deletarEditora(Long id) {
        editorasRepository.deleteById(id);
    }
}
