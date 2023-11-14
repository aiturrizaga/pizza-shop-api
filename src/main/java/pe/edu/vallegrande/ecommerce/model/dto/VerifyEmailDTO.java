package pe.edu.vallegrande.ecommerce.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class VerifyEmailDTO {
    private String message;
    private String email;
    private boolean verified;
}
