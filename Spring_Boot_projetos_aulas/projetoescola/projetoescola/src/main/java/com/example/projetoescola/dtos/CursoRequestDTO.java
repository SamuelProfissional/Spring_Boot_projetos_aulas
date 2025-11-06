package com.example.projetoescola.dtos;

import com.example.projetoescola.validations.NomeCursoValidation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CursoRequestDTO {

    private Long id;
    @NotBlank(message = "The name is mandatory(O nome é obrigatorio)")
    @NomeCursoValidation(message = "NOME DO CURSO FORA DO PADRÃO")
    private String nome;
    @Min(value = 0, message = "A Carga Horaria deve ser maior que zero")
    @Max(value = 4000,message = "A Carga Horaia deve ser menor que 4000")
    private Integer cargaHoraria;
   
    private Integer idCategoriaCurso;
    
}
