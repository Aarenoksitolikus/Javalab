package ru.itis.javalab.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Profile("dev")
@Repository
public class UsersRepositoryFakeImpl implements UsersRepository {

    @Override
    public List<User> findAll() {
        List<User> result = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            result.add(User.builder()
                    .username("Fake" + i)
                    .email("fake" + i + "@gmail.com")
                    .build());
        }
        return result;
    }

    @Override
    public List<User> findAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(User.builder()
                .username("FAKE")
                .email("FAKE@gmail.com")
                .build());
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
