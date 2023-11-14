package pe.edu.vallegrande.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.vallegrande.ecommerce.model.dto.CategoryDTO;
import pe.edu.vallegrande.ecommerce.model.dto.PersonAddressDTO;
import pe.edu.vallegrande.ecommerce.model.entity.Category;
import pe.edu.vallegrande.ecommerce.model.entity.PersonAddress;
import pe.edu.vallegrande.ecommerce.service.PersonAddressService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Address")
@RequiredArgsConstructor
@RequestMapping("/v1/addresses")
public class AddressController {

    private final PersonAddressService personAddressService;

    @Operation(summary = "Get addresses by user id")
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<PersonAddress>> getUserAddress(@PathVariable Long userId) {
        return ResponseEntity.ok(personAddressService.findByUser(userId));
    }

    @Operation(summary = "Get address by id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<PersonAddress>> getAddress(@PathVariable Long id) {
        return ResponseEntity.ok(personAddressService.findById(id));
    }

    @Operation(summary = "Create new address")
    @PostMapping
    public ResponseEntity<PersonAddress> saveAddress(@RequestBody PersonAddressDTO category) {
        PersonAddress response = personAddressService.create(category);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @Operation(summary = "Update address by id")
    @PutMapping("/{id}")
    public ResponseEntity<PersonAddress> updateAddress(@PathVariable Long id, @RequestBody PersonAddressDTO address) {
        return ResponseEntity.ok(personAddressService.update(id, address));
    }

    @Operation(summary = "Delete address by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        personAddressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
