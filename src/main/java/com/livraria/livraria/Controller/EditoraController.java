package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Editoras;
import com.livraria.livraria.Services.EditoresServices;
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

    /*@PutMapping("/editarEditoras")
    public Editoras editarEditora(@RequestBody @Valid Editoras editoras) {
        return editoresServices.AtualizarEditoras(editoras);
    }*/

    @GetMapping("/listarEditoras")
    public List<Editoras> listarEditoras() {
        return editoresServices.listarTodosEditoras();
    }

    @GetMapping("/buscarPeloNome/{nome}")
    public Optional<Editoras> buscarPeloNome(@PathVariable @Valid String nome) {
        return editoresServices.buscarPorEditora(nome);
    }
    @GetMapping("buscarEditoraPorId/{id}")
    public Optional<Editoras> buscarPorid(@PathVariable @Valid Long id) {
        return editoresServices.buscarPorId(id);
    }
    @PutMapping("/editarEditoras/{id}")
    public Editoras atualizarEditoras(@PathVariable @Valid Editoras editoras) {
        return editoresServices.AtualizarEditoras(editoras);
    }
}
