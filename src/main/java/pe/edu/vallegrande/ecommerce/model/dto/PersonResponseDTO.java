package pe.edu.vallegrande.ecommerce.model.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class PersonResponseDTO {
    private Long id;

    @Size(max = 50)
    @NotEmpty
    private String name;

    @Size(max = 50)
    @NotEmpty
    private String lastname;

    @NotNull
    @Past
    private LocalDate birthdate;

    @Size(max = 10)
    private String phone;

    @Size(max = 50)
    @Email
    @NotEmpty
    private String email;
}
