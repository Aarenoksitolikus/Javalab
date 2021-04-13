package ru.itis.javalab.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.validation.ValidPasswords;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    private String hashPassword;
    private String confirmCode;

    @Enumerated(value = EnumType.STRING)
    private State state;

    public enum State {
        CONFIRMED, NOT_CONFIRMED
    }
}

