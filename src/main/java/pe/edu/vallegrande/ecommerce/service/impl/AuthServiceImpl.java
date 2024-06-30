package pe.edu.vallegrande.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.ecommerce.exception.NotFoundException;
import pe.edu.vallegrande.ecommerce.exception.UnverifiedEmailException;
import pe.edu.vallegrande.ecommerce.model.dto.LoginDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonResponseDTO;
import pe.edu.vallegrande.ecommerce.model.dto.VerifyEmailDTO;
import pe.edu.vallegrande.ecommerce.model.mapper.PersonMapper;
import pe.edu.vallegrande.ecommerce.repository.PersonRepository;
import pe.edu.vallegrande.ecommerce.service.AuthService;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    @Override
    public PersonResponseDTO login(LoginDTO dto) {
        return personRepository.findOneByEmailAndPassword(dto.getEmail(), dto.getPassword())
                .map(personMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Incorrect username or password"));
    }

    @Transactional
    @Override
    public VerifyEmailDTO verifyEmail(UUID uuid) {
        return personRepository.findByUuid(uuid)
                .map(person -> {
                    personRepository.verifyEmailByUUID(uuid);
                    return VerifyEmailDTO.builder()
                            .email(person.getEmail())
                            .message("Email successfully verified")
                            .verified(true)
                            .build();
                })
                .orElseThrow(() -> new UnverifiedEmailException("Email has not been verified"));
    }

    @Override
    public Object register(Object request) {
        log.info("Request object: {}", request);
        return request;
    }
}
