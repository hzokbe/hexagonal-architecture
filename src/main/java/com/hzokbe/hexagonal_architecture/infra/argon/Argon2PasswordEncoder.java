package com.hzokbe.hexagonal_architecture.infra.argon;

import com.hzokbe.hexagonal_architecture.domain.user.port.out.PasswordEncoder;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Argon2PasswordEncoder implements PasswordEncoder {
    private final Argon2 argon2 = Argon2Factory.create();

    @Override
    public String encode(String raw) {
        return argon2.hash(2, 65_536, 1, raw.getBytes());
    }
}
