package ru.itis.javalab.dto;

import lombok.Data;
import ru.itis.javalab.validation.Password;
import ru.itis.javalab.validation.Username;
import ru.itis.javalab.validation.ValidPasswords;

import javax.validation.constraints.Email;

@Data
@ValidPasswords(
        message = "{errors.password.mismatch}",
        password = "password",
        checkPassword = "checkPassword"
)

public class UserForm {
    @Email(message = "{errors.incorrect.email}")
    private String email;

    @Password(message = "{errors.invalid.password}")
    private String password;

    private String checkPassword;

    @Username
    private String username;
}
