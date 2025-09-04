package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity // Define que sera uma tabela no banco de dados
public class CategoriaCurso {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;

    @OneToMany(mappedBy="categoriaCurso")// aponta para a fave estrangeira que está em Curso
        private List<Curso> cursos;

    public CategoriaCurso() {
    }

    public CategoriaCurso(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
