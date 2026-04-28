package com.hzokbe.hexagonal_architecture.domain.user;

import java.util.UUID;

public class User {
    private final UUID id;

    private final String username;

    private String passwordHash;

    private boolean isActive = true;

    public User(String username, String passwordHash) {
        if (username == null) {
            throw new IllegalArgumentException("username cannot be null");
        }

        if (username.isBlank()) {
            throw new IllegalArgumentException("username cannot be blank");
        }

        if (passwordHash == null) {
            throw new IllegalArgumentException("password hash cannot be null");
        }

        if (passwordHash.isBlank()) {
            throw new IllegalArgumentException("password hash cannot be blank");
        }

        id = UUID.randomUUID();

        this.username = username;

        this.passwordHash = passwordHash;
    }

    public User(UUID id, String username, String passwordHash, boolean isActive) {
        if (username == null) {
            throw new IllegalArgumentException("username cannot be null");
        }

        if (username.isBlank()) {
            throw new IllegalArgumentException("username cannot be blank");
        }

        if (passwordHash == null) {
            throw new IllegalArgumentException("password hash cannot be null");
        }

        if (passwordHash.isBlank()) {
            throw new IllegalArgumentException("password hash cannot be blank");
        }

        this.id = id;

        this.username = username;

        this.passwordHash = passwordHash;

        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public boolean isActive() {
        return isActive;
    }

    public void changePassword(String passwordHash) {
        if (passwordHash == null) {
            throw new IllegalArgumentException("password hash cannot be null");
        }

        if (passwordHash.isBlank()) {
            throw new IllegalArgumentException("password hash cannot be blank");
        }

        this.passwordHash = passwordHash;
    }

    public void activate() {
        if (isActive) {
            throw new IllegalStateException("already active");
        }

        isActive = true;
    }

    public void deactivate() {
        if (!isActive) {
            throw new IllegalStateException("not active");
        }

        isActive = false;
    }
}
