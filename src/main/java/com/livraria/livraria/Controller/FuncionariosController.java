package com.livraria.livraria.Controller;

import com.livraria.livraria.Entity.Funcionarios;
import com.livraria.livraria.Services.FuncionariosServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FuncionariosController {
    @Autowired
    FuncionariosServices funcionariosServices;

    public FuncionariosController(FuncionariosServices funcionariosServices) {
        this.funcionariosServices = funcionariosServices;
    }

    @PostMapping("/cadastrarFuncionarios")
    public void cadastrarFuncionarios(@Valid @RequestBody Funcionarios funcionarios) {
        funcionariosServices.cadastrarFuncionarios(funcionarios);
    }

    @GetMapping("/listarTodosFuncionarios")
    public List<Funcionarios> listarTodosFuncionarios() {
        return funcionariosServices.listarTodosFuncionarios();
    }

    @DeleteMapping("/deletarFuncionario/{id}")
    public void deletarFuncionarios(@PathVariable long id) {
        funcionariosServices.deletarFuncionarios(id);
    }

    @PutMapping("/editarEnderecos")
    public Funcionarios editarFuncionario(@RequestBody Funcionarios funcionarios) {
        return funcionariosServices.editarFuncionarios(funcionarios);
    }

    /*@GetMapping("/buscarFuncionarios")
    public Optional<Funcionarios> buscarFuncionarios(long id) {
        return funcionariosServices.buscarFuncionarios(id);
    }*/

    @GetMapping("buscarPorId")
    public Optional<Funcionarios> buscarPorId(Long id) {
        return funcionariosServices.buscarFuncionarios(id);
    }

   /* @PutMapping("/editarFuncionarios")
    public Funcionarios editarFuncionarios(@RequestBody Funcionarios funcionarios) {
        return funcionariosServices.editarFuncionarios(funcionarios);
    }*/

    @PutMapping("/atualizarFuncionarios/{id}")
    public ResponseEntity<Void> atualizarFuncionarios(@PathVariable Long id, @RequestBody Funcionarios funcionarios) {
        funcionarios.setId(id);
        funcionariosServices.atualizarFuncionarios(funcionarios);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /*@PutMapping("/inativarAutores/{id}")
    public ResponseEntity<Void> inativarFuncionarios(@PathVariable Long id) {
        funcionariosServices.inativarAutores(id);
        return new ResponseEntity<>(HttpStatus.OK);*/
}


