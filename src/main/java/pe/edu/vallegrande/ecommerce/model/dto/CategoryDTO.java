package pe.edu.vallegrande.ecommerce.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryDTO {
    @Size(max = 50)
    @NotEmpty
    private String name;

    @Size(max = 100)
    private String description;

    @Size(max = 100)
    @NotEmpty
    private String slug;

    private Boolean shortcut;
}