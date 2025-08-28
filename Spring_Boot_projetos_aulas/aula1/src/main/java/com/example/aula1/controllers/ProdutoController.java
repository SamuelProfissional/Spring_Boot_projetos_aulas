package com.example.aula1.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.aula1.models.Produto;
import com.example.aula1.models.SomaDTO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProdutoController {

    ArrayList<Produto> produtos = new ArrayList<>();

    @PostMapping("/produtos")
    public void inserir(@RequestBody Produto dado) {

        produtos.add(dado);
    }

    @PostMapping("/somar")
    public Integer somar(@RequestBody SomaDTO dado) {
        return dado.getNum1() + dado.getNum2();
    }

}
