package com.example.aula1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula1.models.SomaDTO;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ExemploController {
    @GetMapping("ola")
    public String OlaMundo(
        @RequestParam(value= "nome")String nome,
        @RequestParam(value= "sobreNome")String sobreNome){
        return "Olá Mundo " + nome + " " + sobreNome;
    }
    @GetMapping("/obter-por-id/{id}")
    public String obterPorId(@PathVariable (value= "id")int id){
        return "ID: " + id;
    }
    
    @PostMapping("/somar")
    public Integer somar(@RequestBody SomaDTO dado) {
        return dado.getNum1() + dado.getNum2();
    }
    
    
}
