package pe.edu.vallegrande.ecommerce.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShopCartDTO {
    @NotNull
    private Long userId;
    @NotNull
    private Long productId;
}
