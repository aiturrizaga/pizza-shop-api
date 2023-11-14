package pe.edu.vallegrande.ecommerce.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class ExceptionResponse {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
