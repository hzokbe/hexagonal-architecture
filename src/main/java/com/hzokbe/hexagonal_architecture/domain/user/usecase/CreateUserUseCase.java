package com.hzokbe.hexagonal_architecture.domain.user.usecase;

import com.hzokbe.hexagonal_architecture.domain.user.User;
import com.hzokbe.hexagonal_architecture.domain.user.port.in.CreateUserPort;
import com.hzokbe.hexagonal_architecture.domain.user.port.out.PasswordEncoder;
import com.hzokbe.hexagonal_architecture.domain.user.port.out.UserRepository;

public class CreateUserUseCase implements CreateUserPort {
    private final UserRepository repository;

    private final PasswordEncoder encoder;

    public CreateUserUseCase(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;

        this.encoder = encoder;
    }

    @Override
    public User create(String username, String password) {
        if (repository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("username already in use");
        }

        var passwordHash = encoder.encode(password);

        var user = new User(username, passwordHash);

        return repository.save(user);
    }
}
