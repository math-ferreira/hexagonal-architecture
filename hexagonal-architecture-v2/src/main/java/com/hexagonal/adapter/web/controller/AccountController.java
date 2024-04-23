package com.hexagonal.adapter.web.controller;

import com.hexagonal.adapter.web.dto.CreateAccountRequestDTO;
import com.hexagonal.adapter.web.dto.ModifyAccountRequestDTO;
import com.hexagonal.application.usecases.AccountUseCase;
import com.hexagonal.domain.command.ModifyAccount;
import com.hexagonal.domain.command.RegisterAccount;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
@Tag(name = "Account controller")
public class AccountController {

    private final AccountUseCase accountUseCase;

    public AccountController(AccountUseCase accountUseCase) {
        this.accountUseCase = accountUseCase;
    }

    @PostMapping
    @Operation(summary = "Register a new Customer Account")
    @ApiResponses(value = {@ApiResponse(responseCode = "204")})
    public ResponseEntity<?> registerBook(@RequestBody CreateAccountRequestDTO createAccountRequestDTO) {
        final RegisterAccount registerAccount = createAccountRequestDTO.toDomain();
        accountUseCase.registerAccount(registerAccount);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Customer Account")
    @ApiResponses(value = {@ApiResponse(responseCode = "204")})
    public ResponseEntity<?> updateBook(
            @PathVariable UUID id,
            @RequestBody ModifyAccountRequestDTO modifyAccountRequestDTO
    ) {
        final ModifyAccount modifyAccount = modifyAccountRequestDTO.toDomain(id);
        accountUseCase.modifyAccount(modifyAccount);
        return ResponseEntity.noContent().build();
    }

}
