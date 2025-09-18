package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.ToString;

@Entity
public class Diciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// strategy = GenerationType.AUTO  significa 
    //Spring, escolha a melhor estratégia de geração de ID dependendo do banco de dados que eu estiver usando.
    private Long id;
    @Column(nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "diciplinas", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Curso> cursos;

    public Diciplina() {
    }

    public Diciplina(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

}
