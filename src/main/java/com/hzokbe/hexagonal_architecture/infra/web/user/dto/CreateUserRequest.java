package com.hzokbe.hexagonal_architecture.infra.web.user.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreateUserRequest(
        @NotBlank(message = "username cannot be blank")
        @Length(max = 16, message = "username must be at most 16 characters")
        String username,
        @NotBlank(message = "password cannot be blank")
        @Length(max = 64, message = "password must be at most 64 characters")
        String password
) {
}
