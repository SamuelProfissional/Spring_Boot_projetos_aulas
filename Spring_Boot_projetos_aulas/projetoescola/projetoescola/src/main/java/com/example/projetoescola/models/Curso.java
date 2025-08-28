package com.example.projetoescola.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Curso {
    
    @Id
    @GeneratedValue //gera o id que se auto incrementa

    private Long id;
    @Column(nullable = false)// valores não podem ser nulos
    private String nome;
    private Integer cargaHoraria;


    
    public Curso() {
    }

    public Curso(Long id, String nome, Integer cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso [id=" + id + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + "]";
    }

}
