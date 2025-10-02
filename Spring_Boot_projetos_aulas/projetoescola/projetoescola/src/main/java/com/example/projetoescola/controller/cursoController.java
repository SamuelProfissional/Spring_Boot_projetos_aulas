package com.example.projetoescola.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.services.CursoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/curso")
public class cursoController {

    
    private CursoService cursoService;

    public cursoController(CursoService cursoService){

        this.cursoService = cursoService;
    }

    @PostMapping
    public void criarCurso(@RequestBody CursoRequestDTO cursoRequestDTO) { 
        cursoService.salvar(cursoRequestDTO);
    }
    
    
}
