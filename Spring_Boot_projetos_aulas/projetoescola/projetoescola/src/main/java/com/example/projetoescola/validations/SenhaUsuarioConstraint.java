package com.example.projetoescola.validations;

import com.example.projetoescola.models.Usuario;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.val;

public class SenhaUsuarioConstraint implements ConstraintValidator<SenhaUsuarioValidation, Usuario> {
    @Override
    public boolean isValid(
        Usuario value, ConstraintValidatorContext context) {
        try {
            if (!value.getSenha().equals(value.getConfirmarSenha())) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
// terminar validacão dasenha 