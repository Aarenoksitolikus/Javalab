package ru.itis.javalab.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;

import javax.persistence.Access;
import java.util.List;
import java.util.Optional;

@Profile("master")
@Repository
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private static final String tableName = "account";

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper userRowMapper = (row, i) -> User.builder().
            id(row.getLong("id"))
            .username(row.getString("username"))
            .email(row.getString("email"))
            .hashPassword(row.getString("hash_password"))
            .build();

    UsersRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update(SQL_INSERT_USER, entity.getUsername(), entity.getEmail(), entity.getHashPassword(), entity.getConfirmCode(), entity.getState().toString());
    }

    @Override
    public void delete(Long aLong) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, aLong);
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        User user;
        try {
            user = (User) jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }

        return Optional.ofNullable(user);

    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public List<User> findAll(int page, int size) {
        return jdbcTemplate.query(SQL_SELECT_ALL_FROM_PAGE, userRowMapper, size, page);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    //language=SQL
    private static final String SQL_SELECT_ALL = "SELECT * FROM " + tableName;

    //language=SQL
    private static final String SQL_SELECT_ALL_FROM_PAGE = "select * from " + tableName + " order by id limit ? offset ? ;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from " + tableName + " where id = ?";

    //language=SQL
    private static final String SQL_INSERT_USERNAME_AND_EMAIL = "insert into " + tableName + " (username, email) values (?, ?)";

    //language=SQL
    private static final String SQL_INSERT_USER = "insert into " + tableName + " (username, email, hash_password, confirm_code, state) values (?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_DELETE_BY_ID = "delete from " + tableName + " where id = ?";
}
