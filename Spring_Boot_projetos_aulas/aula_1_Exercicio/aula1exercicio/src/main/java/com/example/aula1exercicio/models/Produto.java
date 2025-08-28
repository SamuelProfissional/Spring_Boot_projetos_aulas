package com.example.aula1exercicio.models;

public class Produto {

    private Long id;
    private String name;
    private double preco;


    public Produto() {
    }
    
    public Produto(Long id, String name, double preco) {
        this.id = id;
        this.name = name;
        this.preco = preco;
    }

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
