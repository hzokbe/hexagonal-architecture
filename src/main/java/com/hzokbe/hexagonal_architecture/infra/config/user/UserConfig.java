package com.hzokbe.hexagonal_architecture.infra.config.user;

import com.hzokbe.hexagonal_architecture.domain.user.port.in.CreateUserPort;
import com.hzokbe.hexagonal_architecture.domain.user.port.out.PasswordEncoder;
import com.hzokbe.hexagonal_architecture.domain.user.port.out.UserRepository;
import com.hzokbe.hexagonal_architecture.domain.user.usecase.CreateUserUseCase;
import com.hzokbe.hexagonal_architecture.infra.argon.Argon2PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public CreateUserPort createUserPort(UserRepository repository, PasswordEncoder encoder) {
        return new CreateUserUseCase(repository, encoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Argon2PasswordEncoder();
    }
}
