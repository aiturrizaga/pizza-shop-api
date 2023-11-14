package pe.edu.vallegrande.ecommerce.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ShoppingCartDTO {
    @NotNull
    private Long userId;
    @NotNull
    private Long productId;
    @NotNull
    private Integer quantity;
}