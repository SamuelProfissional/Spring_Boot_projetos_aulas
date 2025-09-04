package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {

    @Id
    @GeneratedValue // gera o id que se auto incrementa

    private Long id;
    @Column(nullable = false) // valores não podem ser nulos
    private String nome;
    private Integer cargaHoraria;

    @ManyToOne // indica relação de n para i no relacionamento do banco de dados
    @JoinColumn(name = "categoriaCurso_id") // salva e cria a o nome categoriaCurso_id como chave estrangeira no banco de dados.

    private CategoriaCurso categoriaCurso;

    @ManyToMany(cascade = CascadeType.ALL) // O cascade = CascadeType.ALL Quando eu mexer no objeto principal, quero que você automaticamente faça o mesmo com os objetos relacionados.
    @JoinTable(name = "DICIPLINA_CURSO", joinColumns = {
            // cria a chave estrangeira na tabvela de diciplina||        Cria a chave estrangeira de de diciplina na tabela de curso
            @JoinColumn(name = "CURSO_ID") }, inverseJoinColumns = { @JoinColumn(name = "DISIPLINA_ID") })
    private List<Diciplina> diciplinas;




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


    

    public CategoriaCurso getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(CategoriaCurso categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }

    public List<Diciplina> getDiciplinas() {
        return diciplinas;
    }

    public void setDiciplinas(List<Diciplina> diciplinas) {
        this.diciplinas = diciplinas;
    }

}
