package com.example.projetoescola.dtos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.MethodArgumentNotValidException;

import lombok.Getter;

public class ApiErrorDTO {

    @Getter
    private List<String> errors;

    public ApiErrorDTO(String mensagem) {
        this.errors = Arrays.asList(mensagem);

    }

    public ApiErrorDTO(List<String> erros) {
        this.errors = erros;
    }

    public ApiErrorDTO validationError(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult().getFieldErrors().stream()
                .map(erro -> erro.getDefaultMessage())
                .collect(
                        Collectors.toList());
        return new ApiErrorDTO(erros);
    }

}
