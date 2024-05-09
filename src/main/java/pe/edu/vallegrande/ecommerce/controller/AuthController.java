package pe.edu.vallegrande.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.ecommerce.model.dto.*;
import pe.edu.vallegrande.ecommerce.service.AuthService;

import java.util.UUID;

@RestController
@Tag(name = "Authorization")
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "User login")
    @PostMapping
    public ResponseEntity<PersonResponseDTO> login(@RequestBody LoginDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @Operation(summary = "Verify email")
    @PostMapping("/verify-email/{uuid}")
    public ResponseEntity<VerifyEmailDTO> verifyEmail(@PathVariable UUID uuid) {
        return ResponseEntity.ok(authService.verifyEmail(uuid));
    }

    @Operation(summary = "Register data")
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody Object request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
