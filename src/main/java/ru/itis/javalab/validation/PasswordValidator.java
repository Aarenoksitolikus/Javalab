package ru.itis.javalab.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{6,}$");
    }
}
