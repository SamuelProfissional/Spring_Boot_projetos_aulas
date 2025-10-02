package com.example.projetoescola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ExemploController {
    
    @Autowired
    @Qualifier("versao")
    private String versao;

    @Autowired
    @Qualifier("nome")
    private String nome;

    @GetMapping("/versao")
    public String getVersaoApi() {
        return  versao + " | " + nome;
    }
    

}
