package com.hzokbe.hexagonal_architecture.domain.user.port.out;

public interface PasswordEncoder {
    String encode(String password);
}
