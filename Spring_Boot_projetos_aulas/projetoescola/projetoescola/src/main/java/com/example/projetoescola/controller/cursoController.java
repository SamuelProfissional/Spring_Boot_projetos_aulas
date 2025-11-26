package com.example.projetoescola.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.dtos.CursoDTO;
import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.services.CursoService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/curso")
@SecurityRequirement(name = "Bearer Authentication")
public class cursoController {

    private CursoService cursoService;

    public cursoController(CursoService cursoService) {

        this.cursoService = cursoService;
    }

    @PostMapping
    public void criarCurso(@Valid @RequestBody CursoRequestDTO cursoRequestDTO) {
        cursoService.salvar(cursoRequestDTO);
    }

    @GetMapping("{id}")
    public CursoDTO obterPorId(@PathVariable Long id) {
        return cursoService.obterPorId(id);
    }

    @GetMapping()
    public List<CursoDTO> obterTodos() {
        return cursoService.obtertodos();   
    }

    @PutMapping("/{id}")
    public void editarCurso(@Valid @PathVariable Long id, @RequestBody CursoRequestDTO cursoRequestDTO) {
        cursoService.editar(id, cursoRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void removerCurso(@PathVariable Long id) {
        cursoService.remover(id);
    }

}
