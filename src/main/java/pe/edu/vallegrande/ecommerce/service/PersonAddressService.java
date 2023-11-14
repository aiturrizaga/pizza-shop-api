package pe.edu.vallegrande.ecommerce.service;

import pe.edu.vallegrande.ecommerce.model.dto.PersonAddressDTO;
import pe.edu.vallegrande.ecommerce.model.entity.PersonAddress;

import java.util.List;
import java.util.Optional;

public interface PersonAddressService {
    List<PersonAddress> findByUser(Long userId);

    Optional<PersonAddress> findById(Long id);

    PersonAddress create(PersonAddressDTO dto);

    PersonAddress update(Long id, PersonAddressDTO dto);

    void deleteById(Long id);
}
