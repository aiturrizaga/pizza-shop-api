package pe.edu.vallegrande.ecommerce.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ProductDTO {
    @NotEmpty
    private String name;

    private String description;

    private String imageUrl;

    private Integer rating;

    private Long categoryId;

    private String slug;

    @NotNull
    @PositiveOrZero
    private BigDecimal price;
}