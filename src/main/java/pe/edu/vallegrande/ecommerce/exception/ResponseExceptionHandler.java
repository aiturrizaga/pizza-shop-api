package pe.edu.vallegrande.ecommerce.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pe.edu.vallegrande.ecommerce.model.dto.VerifyEmailDTO;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String msgErr = "Validacion fallida";
        for (ObjectError objErr : ex.getBindingResult().getAllErrors()) {
            msgErr = objErr.getDefaultMessage();
        }

        return ResponseEntity.badRequest()
                .body(ExceptionResponse.builder()
                        .message(msgErr)
                        .timestamp(LocalDateTime.now())
                        .details(ex.getDetailMessageCode())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<ExceptionResponse> handleGlobalException(Exception ex, WebRequest request) {
        return ResponseEntity.internalServerError()
                .body(ExceptionResponse.builder()
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .details(request.getDescription(false))
                        .build());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ExceptionResponse error = ExceptionResponse.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnverifiedEmailException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VerifyEmailDTO> handleUnverifiedEmailException(NotFoundException ex, WebRequest request) {
        return ResponseEntity.ok(
                VerifyEmailDTO.builder()
                        .message(ex.getMessage())
                        .verified(false)
                        .build()
        );
    }
}
