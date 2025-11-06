package com.example.projetoescola.models;

import java.time.LocalDate;

import com.example.projetoescola.validations.SenhaUsuarioValidation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // cria os getts e setters
@NoArgsConstructor // cria um construtor vazio
@AllArgsConstructor // cria um construtor com todos os parametros
@Builder 
@SenhaUsuarioValidation
public class Usuario {


   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false) 
    private String nome;

    @Column(nullable = false) 
    private String email;

    @Column(nullable = false) 
    private String senha;

    @Column(nullable = false) 
    private String confirmarSenha;

    @Column(nullable = false) 
    private LocalDate  dataDeNascimento;




//     nome: obrigatório, não pode ser vazio e deve ter no mínimo 3 e no máximo 50 caracteres.

// email: obrigatório, deve ser um e-mail válido.

// senha: obrigatório, deve ter no mínimo 8 caracteres.

// confirmarSenha: obrigatório, deve ser igual ao campo senha.

// dataDeNascimento:
    
}
