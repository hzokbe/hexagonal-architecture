package com.hzokbe.hexagonal_architecture.domain.user.port.out;

import com.hzokbe.hexagonal_architecture.domain.user.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(UUID id);

    Optional<User> findByUsername(String username);

    void deleteById(UUID id);
}
