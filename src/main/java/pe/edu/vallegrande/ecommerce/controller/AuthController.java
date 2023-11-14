package pe.edu.vallegrande.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.ecommerce.model.dto.LoginDTO;

@RestController
@Tag(name = "Authorization")
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    @Operation(summary = "User login")
    @PostMapping
    public ResponseEntity<Object> login(@RequestBody LoginDTO login) {
        return ResponseEntity.ok("");
    }
}
