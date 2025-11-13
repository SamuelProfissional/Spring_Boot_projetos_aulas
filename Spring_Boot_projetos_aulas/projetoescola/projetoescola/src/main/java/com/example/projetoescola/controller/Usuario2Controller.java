package com.example.projetoescola.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.dtos.Usuario2RequestDTO;
import com.example.projetoescola.services.CursoService;
import com.example.projetoescola.services.Usuario2Service;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class Usuario2Controller {
    
    private Usuario2Service usuarioService;

     public Usuario2Controller(Usuario2Service usuarioService) {

        this.usuarioService = usuarioService;
    }


     @PostMapping
    public void criarUsuario(@Valid @RequestBody Usuario2RequestDTO usuarioRequestDTO) {
        usuarioService.salvar(usuarioRequestDTO);
    }
}
