package pe.edu.vallegrande.ecommerce.service;

import pe.edu.vallegrande.ecommerce.model.dto.PersonDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonResponseDTO;

public interface PersonService {
    PersonResponseDTO findById(Long id);

    PersonResponseDTO create(PersonDTO person);

    PersonResponseDTO update(Long id, PersonDTO person);

    void disabledById(Long id);
}
