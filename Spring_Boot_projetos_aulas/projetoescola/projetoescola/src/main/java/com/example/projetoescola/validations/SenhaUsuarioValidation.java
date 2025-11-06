package com.example.projetoescola.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;



    @Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = NomeCursoConstraint.class)
public @interface SenhaUsuarioValidation {
    String message() default "Nome fora do padrão";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
    

