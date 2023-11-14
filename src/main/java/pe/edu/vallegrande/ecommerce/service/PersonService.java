package pe.edu.vallegrande.ecommerce.service;

import pe.edu.vallegrande.ecommerce.model.dto.PersonDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonResponseDTO;
import pe.edu.vallegrande.ecommerce.model.dto.VerifyEmailDTO;

import java.util.UUID;

public interface PersonService {
    PersonResponseDTO findById(Long id);

    PersonResponseDTO create(PersonDTO person);

    PersonResponseDTO update(Long id, PersonDTO person);

    VerifyEmailDTO verifyEmail(UUID uuid);

    void disabledById(Long id);
}
