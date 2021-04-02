package ru.itis.javalab.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.javalab.services.UsersService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {

    @Autowired
    private UsersService usersService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return usersService.getUser(s) == null;
    }
}
