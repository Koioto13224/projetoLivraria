package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Editoras;
import com.livraria.livraria.Entity.Enderecos;
import com.livraria.livraria.Entity.Funcionarios;
import com.livraria.livraria.Services.EnderecosServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnderecosController {

    EnderecosServices enderecosServices;

    public EnderecosController(EnderecosServices enderecosServices) {
        this.enderecosServices = enderecosServices;
    }

    @PostMapping("/cadastrarEndereco")
    public void cadastrarEndereco(@Valid @RequestBody Enderecos enderecos) {
        enderecosServices.cadastrarEnderecos(enderecos);
    }

    @DeleteMapping("deletarEnderecos/{id}")
    public void deletarEnderecos(@PathVariable Long id) {
        enderecosServices.deletarEnderecos(id);
    }

    @PutMapping("/editarEnderecos/{id}")
    public Enderecos editarEndereco(@RequestBody @Valid @PathVariable Enderecos enderecos) {
        return enderecosServices.editarEnderecos(enderecos);
    }

    @GetMapping("/listarEnderecos")
    public List<Enderecos> listarEnderecos() {
        return enderecosServices.listarTodosEnderecos();
    }
//    @PutMapping("/editarEditoras/{id}")
//    public Enderecos atualizarEditoras(@PathVariable @Valid Enderecos enderecos) {
//        return enderecosServices.atualizarEnderecos(enderecos);
//    }
    /*@GetMapping("/buscarPelaCidade")
    public Optional<Enderecos> buscarPorId(@PathVariable String cidade) {
        return enderecosServices.buscarPeloCidade(cidade);
    }*/

    /*@PutMapping("/editarEnderecos/{id}")
    public ResponseEntity<Void> atualizarEnderecos(@PathVariable Long id, @RequestBody Enderecos enderecos) {
        enderecos.setRua(enderecos.getRua());
        enderecosServices.atualizarEnderecos(enderecos);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
