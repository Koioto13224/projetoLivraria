package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Editoras;
import com.livraria.livraria.Services.EditoresServices;
import com.livraria.livraria.dto.EditorasDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EditoraController {

    private EditoresServices editoresServices;

    public EditoraController(EditoresServices editoresServices) {
        this.editoresServices = editoresServices;
    }

    @PostMapping("/cadastrarEditora")
    public void cadastrarEditora(@Valid @RequestBody Editoras editoras) {
        editoresServices.cadastrarEditoras(editoras);
    }

    @DeleteMapping("/DeletarEditora/{id}")
    public void deletarEditoras(@PathVariable Long id) {
        editoresServices.deletarEditora(id);
    }

    @GetMapping("/listarEditoras")
    public List<EditorasDTO> listarEditoras() {
        return editoresServices.listarTodasEditoras();
    }

    @GetMapping("/buscarPeloNome/{nome}")
    public EditorasDTO buscarPeloNome(@PathVariable @Valid String nome) {
        return editoresServices.buscarPorEditora(nome);
    }
    @GetMapping("buscarEditoraPorId/{id}")
    public EditorasDTO buscarPorid(@PathVariable @Valid Long id) {
        return editoresServices.buscarPorId(id);
    }
    @PutMapping("/editarEditoras/{id}")
    public Editoras atualizarEditoras(@PathVariable @Valid Editoras editoras) {
        return editoresServices.AtualizarEditoras(editoras);
    }
}
