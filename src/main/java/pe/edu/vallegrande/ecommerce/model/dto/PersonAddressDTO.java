package pe.edu.vallegrande.ecommerce.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class PersonAddressDTO {
    @NotNull
    private Long userId;
    @NotNull
    @Size(max = 100)
    private String address;
    @NotNull
    private BigDecimal latitude;
    @NotNull
    private BigDecimal longitude;
}