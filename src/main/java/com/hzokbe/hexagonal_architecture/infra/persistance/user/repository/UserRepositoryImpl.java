package com.hzokbe.hexagonal_architecture.infra.persistance.user.repository;

import com.hzokbe.hexagonal_architecture.domain.user.User;
import com.hzokbe.hexagonal_architecture.domain.user.port.out.UserRepository;
import com.hzokbe.hexagonal_architecture.infra.persistance.user.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserEntityRepository userEntityRepository;

    public UserRepositoryImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public User save(User user) {
        var userEntity = userEntityRepository.save(UserEntity.fromDomain(user));

        return userEntity.toDomain();
    }

    @Override
    public Optional<User> findById(UUID id) {
        var optionalUserEntity = userEntityRepository.findById(id);

        return optionalUserEntity.map(UserEntity::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        var optionalUserEntity = userEntityRepository.findByUsername(username);

        return optionalUserEntity.map(UserEntity::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        userEntityRepository.deleteById(id);
    }
}
