package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Autores;
import com.livraria.livraria.Entity.Editoras;
import com.livraria.livraria.Entity.Livros;
import com.livraria.livraria.Repository.EditorasRepository;
import com.livraria.livraria.Repository.LivrosRepository;
import com.livraria.livraria.dto.AutoresDTO;
import com.livraria.livraria.dto.EditorasDTO;
import com.livraria.livraria.dto.LivrosDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EditoresServices {
    @Autowired
    EditorasRepository editorasRepository;
    @Autowired
    LivrosRepository livrosRepository;

    @Autowired
    ModelMapper modelMapper;

    public EditoresServices(EditorasRepository editorasRepository) {
        this.editorasRepository = editorasRepository;
    }

    public void cadastrarEditoras(Editoras editoras) {
        editorasRepository.save(editoras);
    }

    public List<EditorasDTO> listarTodasEditoras() {
        List<Editoras> editoras = editorasRepository.findAll();
        List<EditorasDTO> editorasDTO = new ArrayList<>();

        for (Editoras editora:editoras){
            EditorasDTO editorasDTOS = modelMapper.map(editora,EditorasDTO.class);

            List<LivrosDTO>  livrosDTOS = editorasDTOS.getLivros();
            for (LivrosDTO livrosDTO: livrosDTOS){
                Livros livros = livrosRepository.findById(livrosDTO.getId()).orElse(null);
                if (livros != null) {
                    livrosDTO.setIdcategorias(livros.getCategorias().getId());
                    livrosDTO.setIdeditora(livros.getEditoras().getId());
                }
            }
            editorasDTO.add(editorasDTOS);
        }
        return editorasDTO;
    }

    public EditorasDTO buscarPorId(Long id) {
        Optional<Editoras> editorasOptional = editorasRepository.findById(id);

        if (editorasOptional.isPresent()) {
            Editoras editora = editorasOptional.get();
            EditorasDTO editorasDTO = modelMapper.map(editora, EditorasDTO.class);

            List<LivrosDTO> livrosDTOS = new ArrayList<>();
            for (Livros livro : editora.getLivros()) {
                LivrosDTO livrosDTO = modelMapper.map(livro, LivrosDTO.class);
                livrosDTO.setIdcategorias(livro.getCategorias().getId());
                livrosDTO.setIdeditora(livro.getEditoras().getId());
                livrosDTOS.add(livrosDTO);
            }
            editorasDTO.setLivros(livrosDTOS);

            return editorasDTO;
        } else {
            throw new IllegalArgumentException("Editora não encontrada com o ID: " + id);
        }
    }

    public Editoras AtualizarEditoras (Editoras editoras) {
        return editorasRepository.save(editoras);
    }

    public EditorasDTO buscarPorEditora(String nome) {
        List<Editoras> editoras = editorasRepository.findByNomeContainingIgnoreCase(nome);
        List<EditorasDTO> editorasDTO = new ArrayList<>();


        EditorasDTO editorasDTOS = null;
        for (Editoras editora : editoras) {
            editorasDTOS = modelMapper.map(editora, EditorasDTO.class);

            List<LivrosDTO> livrosDTOS = editorasDTOS.getLivros();
            for (LivrosDTO livrosDTO : livrosDTOS) {
                Livros livros = livrosRepository.findById(livrosDTO.getId()).orElse(null);
                if (livros != null) {
                    livrosDTO.setIdcategorias(livros.getCategorias().getId());
                    livrosDTO.setIdeditora(livros.getEditoras().getId());
                }
            }
            editorasDTO.add(editorasDTOS);
        }

        return editorasDTOS;
    }

    public void deletarEditora(Long id) {
        editorasRepository.deleteById(id);
    }
}
