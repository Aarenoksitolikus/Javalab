package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
