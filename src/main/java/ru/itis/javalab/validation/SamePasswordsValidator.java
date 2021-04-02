package ru.itis.javalab.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordsValidator implements ConstraintValidator<ValidPasswords, Object> {

    private String passwordPropertyName;
    private String checkPasswordPropertyName;

    @Override
    public void initialize(ValidPasswords constraintAnnotation) {
        this.passwordPropertyName = constraintAnnotation.password();
        this.checkPasswordPropertyName = constraintAnnotation.checkPassword();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object password = new BeanWrapperImpl(value).getPropertyValue(passwordPropertyName);
        Object checkPassword = new BeanWrapperImpl(value).getPropertyValue(checkPasswordPropertyName);

        return password != null && password.equals(checkPassword);
    }
}
