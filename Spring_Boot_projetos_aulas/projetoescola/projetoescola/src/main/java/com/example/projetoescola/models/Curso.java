package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data // cria os getts e setters
@NoArgsConstructor // cria um construtor vazio
@AllArgsConstructor // cria um construtor com todos os parametros
@Builder
public class Curso {

    @Id
    @GeneratedValue // gera o id que se auto incrementa

    private Long id;
    @Column(nullable = false) // valores não podem ser nulos
    private String nome;
    private Integer cargaHoraria;

    @ManyToOne // indica relação de n para i no relacionamento do banco de dados
    @JoinColumn(name = "categoriaCurso_id") // salva e cria a o nome categoriaCurso_id como chave estrangeira no banco de dados.
    @ToString.Exclude

    private CategoriaCurso categoriaCurso;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // O cascade = CascadeType.ALL Quando eu mexer no objeto principal, quero que você automaticamente faça o mesmo com os objetos relacionados.
    @JoinTable(name = "DICIPLINA_CURSO", joinColumns = {
            // cria a chave estrangeira na tabvela de diciplina||        Cria a chave estrangeira de de diciplina na tabela de curso
            @JoinColumn(name = "CURSO_ID") }, inverseJoinColumns = { @JoinColumn(name = "DISIPLINA_ID") })
    private List<Diciplina> diciplinas;




}
