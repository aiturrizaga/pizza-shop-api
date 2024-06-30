package pe.edu.vallegrande.ecommerce.service;

import pe.edu.vallegrande.ecommerce.model.dto.LoginDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonResponseDTO;
import pe.edu.vallegrande.ecommerce.model.dto.VerifyEmailDTO;

import java.util.UUID;

public interface AuthService {
    PersonResponseDTO login(LoginDTO dto);

    VerifyEmailDTO verifyEmail(UUID uuid);

    Object register(Object request);
}
