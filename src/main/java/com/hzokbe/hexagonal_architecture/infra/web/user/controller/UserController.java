package com.hzokbe.hexagonal_architecture.infra.web.user.controller;

import com.hzokbe.hexagonal_architecture.domain.user.port.in.CreateUserPort;
import com.hzokbe.hexagonal_architecture.infra.web.user.dto.CreateUserRequest;
import com.hzokbe.hexagonal_architecture.infra.web.user.dto.CreateUserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserPort createUserPort;

    public UserController(CreateUserPort createUserPort) {
        this.createUserPort = createUserPort;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> create(@Valid @RequestBody CreateUserRequest request) {
        var user = createUserPort.create(request.username(), request.password());

        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateUserResponse(user.getId(), user.getUsername()));
    }
}
