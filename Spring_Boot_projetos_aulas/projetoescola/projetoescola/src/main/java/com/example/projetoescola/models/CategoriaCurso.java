package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Define que sera uma tabela no banco de dados
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaCurso {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;

    @OneToMany(mappedBy="categoriaCurso", fetch = FetchType.EAGER)// aponta para a fave estrangeira que está em Curso
        private List<Curso> cursos;


}
