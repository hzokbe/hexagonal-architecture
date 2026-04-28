package com.hzokbe.hexagonal_architecture.infra.web.user.dto;

import java.util.UUID;

public record CreateUserResponse(UUID id, String username) {
}
