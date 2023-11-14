package pe.edu.vallegrande.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.ecommerce.exception.NotFoundException;
import pe.edu.vallegrande.ecommerce.model.dto.PersonAddressDTO;
import pe.edu.vallegrande.ecommerce.model.entity.PersonAddress;
import pe.edu.vallegrande.ecommerce.model.mapper.PersonAddressMapper;
import pe.edu.vallegrande.ecommerce.repository.PersonAddressRepository;
import pe.edu.vallegrande.ecommerce.service.PersonAddressService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonAddressServiceImpl implements PersonAddressService {

    private final PersonAddressMapper personAddressMapper;
    private final PersonAddressRepository personAddressRepository;

    @Override
    public List<PersonAddress> findByUser(Long userId) {
        return personAddressRepository.findAllByUserId(userId);
    }

    @Override
    public Optional<PersonAddress> findById(Long id) {
        return personAddressRepository.findById(id);
    }

    @Override
    public PersonAddress create(PersonAddressDTO dto) {
        return personAddressRepository.save(personAddressMapper.toEntity(dto));
    }

    @Override
    public PersonAddress update(Long id, PersonAddressDTO dto) {
        return personAddressRepository.findById(id)
                .map(res -> personAddressRepository.save(personAddressMapper.partialUpdate(dto, res)))
                .orElseThrow(() -> new NotFoundException("Address not found"));
    }

    @Override
    public void deleteById(Long id) {
        personAddressRepository.deleteById(id);
    }
}
