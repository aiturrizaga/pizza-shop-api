package pe.edu.vallegrande.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.vallegrande.ecommerce.model.dto.PageableDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonResponseDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Person;
import pe.edu.vallegrande.ecommerce.service.PersonService;

import java.net.URI;

@RestController
@Tag(name = "User")
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final PersonService personService;

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<PageableDTO<Person>> getUsers(Pageable pageable) {
        return ResponseEntity.ok(personService.findAll(pageable));
    }

    @Operation(summary = "Get user by id")
    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @Operation(summary = "Created new user")
    @PostMapping
    public ResponseEntity<PersonResponseDTO> saveUser(@RequestBody PersonDTO person) {
        PersonResponseDTO response = personService.create(person);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @Operation(summary = "Update user by id")
    @PutMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> updateUser(@PathVariable Long id, @RequestBody PersonDTO person) {
        return ResponseEntity.ok(personService.update(id, person));
    }

    @Operation(summary = "Disable user by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> disableUser(@PathVariable Long id) {
        personService.disabledById(id);
        return ResponseEntity.noContent().build();
    }

}
