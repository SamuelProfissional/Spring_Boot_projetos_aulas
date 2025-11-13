package com.example.projetoescola.dtos;

import java.time.LocalDate;

import com.example.projetoescola.validations.NomeCursoValidation;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario2RequestDTO {
    

private Long id;
@NotBlank(message = "O nome é obrigatorio")
private String nome;

@Email(message = "Email inválido")
@NotBlank(message = "Email é OBRIGATORIO!")
private String email;

@NotBlank(message = "Senha é OBRIGATORIO!")
@Size(min = 8, max = 8,  message = "A senha deve ter no mínimo 8 caracteres.")
private String senha;

@NotBlank(message = "Confirmação  de Senha é OBRIGATORIO!")
@Size(min = 8, max = 8,  message = "A Confirmação da senha deve ter no mínimo 8 caracteres.")
private String confirmarSenha;

@NotBlank(message = "Data De Nascimento é OBRIGATORIO!") 
@Past (message = "Data De Nascimento deve ser uma data passada (não pode ser futura).")   
private LocalDate  dataDeNascimento;


}
