package com.hzokbe.hexagonal_architecture.infra.persistance.user.entity;

import com.hzokbe.hexagonal_architecture.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "is_active")
    private boolean isActive = true;

    public UserEntity() {
    }

    private UserEntity(UUID id, String username, String passwordHash, boolean isActive) {
        this.id = id;

        this.username = username;

        this.passwordHash = passwordHash;

        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public static UserEntity fromDomain(User user) {
        return new UserEntity(
                user.getId(),
                user.getUsername(),
                user.getPasswordHash(),
                user.isActive()
        );
    }

    public User toDomain() {
        return new User(
                id,
                username,
                passwordHash,
                isActive
        );
    }
}
