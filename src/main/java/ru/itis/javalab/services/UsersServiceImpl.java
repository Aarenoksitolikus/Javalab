package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;
import ru.itis.javalab.utils.EmailUtil;
import ru.itis.javalab.utils.MailsGenerator;

import java.util.List;
import java.util.UUID;

import static ru.itis.javalab.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private MailsGenerator mailsGenerator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.url}")
    private String serverUrl;

    @Value("${spring.mail.username}")
    private String from;

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(usersRepository.findAll());
    }

    @Override
    public List<UserDto> getAllUsers(int page, int size) {
        return from(usersRepository.findAll(page, size));
    }

    @Override
    public void addUser(UserDto userDto) {
        usersRepository.save(User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .confirmCode(UUID.randomUUID().toString())
                .build());
    }

    @Override
    public void addUser(UserForm userForm) {
        User newUser = User.builder()
                .email(userForm.getEmail())
                .username(userForm.getUsername())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .confirmCode(UUID.randomUUID().toString())
                .state(User.State.NOT_CONFIRMED)
                .build();

        usersRepository.save(newUser);

        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, newUser.getConfirmCode());

//        emailUtil.sendMail(newUser.getEmail(), "Registration", from, confirmMail);
    }

    @Override
    public UserDto getUser(Long userId) {
        return UserDto.from(usersRepository.findById(userId).orElse(null));
    }
}
