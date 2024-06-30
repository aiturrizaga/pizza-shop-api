package pe.edu.vallegrande.ecommerce.service;

import org.springframework.data.domain.Pageable;
import pe.edu.vallegrande.ecommerce.model.dto.PageableDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonResponseDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Person;

public interface PersonService {
    PersonResponseDTO findById(Long id);

    PageableDTO<Person> findAll(Pageable pageable);

    PersonResponseDTO create(PersonDTO person);

    PersonResponseDTO update(Long id, PersonDTO person);

    void disabledById(Long id);
}
