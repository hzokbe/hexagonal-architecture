package com.hzokbe.hexagonal_architecture.domain.user.port.in;

import com.hzokbe.hexagonal_architecture.domain.user.User;

public interface CreateUserPort {
    User create(String username, String password);
}
