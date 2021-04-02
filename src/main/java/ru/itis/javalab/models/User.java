package ru.itis.javalab.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class User {
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

