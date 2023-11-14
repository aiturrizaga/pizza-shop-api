package pe.edu.vallegrande.ecommerce.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
public class OrderDTO {
    @NotNull
    private Long userId;
    @NotNull
    @Size(max = 100)
    private String address;
    @NotNull
    @Size(max = 20)
    private String orderType;
    @NotNull
    @Size(max = 30)
    private String paymentMethod;
    private BigDecimal latitude;
    private BigDecimal longitude;
    @NotNull
    @Size(max = 20)
    private String state;

    private Set<OrderItemDTO> items;

    @Getter
    @Setter
    @ToString
    public static class OrderItemDTO {
        @NotNull
        private Long productId;
        @NotNull
        @Min(value = 1)
        @Positive
        private Integer quantity;
    }
}