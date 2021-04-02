package ru.itis.javalab.dto;

import lombok.Data;
import ru.itis.javalab.validation.ValidPassword;

import javax.validation.constraints.Email;

@Data
public class UserForm {
    @Email(message = "{errors.incorrect.email}")
    private String email;

    @ValidPassword(message = "{errors.invalid.password}")
    private String password;

    private String username;
}
