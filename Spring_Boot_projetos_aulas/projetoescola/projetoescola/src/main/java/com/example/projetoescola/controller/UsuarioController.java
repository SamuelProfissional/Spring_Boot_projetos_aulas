package com.example.projetoescola.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.dtos.UsuarioRequestDTO;
import com.example.projetoescola.services.CursoService;
import com.example.projetoescola.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    private UsuarioService usuarioService;

     public UsuarioController(UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }


     @PostMapping
    public void criarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioService.salvar(usuarioRequestDTO);
    }
}
