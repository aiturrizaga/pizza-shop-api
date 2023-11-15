package pe.edu.vallegrande.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.ecommerce.exception.NotFoundException;
import pe.edu.vallegrande.ecommerce.model.dto.PersonDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonResponseDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Person;
import pe.edu.vallegrande.ecommerce.model.mapper.PersonMapper;
import pe.edu.vallegrande.ecommerce.repository.PersonRepository;
import pe.edu.vallegrande.ecommerce.service.PersonService;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    @Override
    public PersonResponseDTO findById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::toResponse)
                .orElseThrow();
    }

    @Override
    public PersonResponseDTO create(PersonDTO dto) {
        Person person = personRepository.save(personMapper.toEntity(dto));
        return personMapper.toResponse(person);
    }

    @Override
    public PersonResponseDTO update(Long id, PersonDTO dto) {
        return personRepository.findById(id)
                .map(res -> {
                    Person person = personRepository.save(personMapper.partialUpdate(dto, res));
                    return personMapper.toResponse(person);
                })
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Transactional
    @Override
    public void disabledById(Long id) {
        personRepository.disableById(id);
    }
}
