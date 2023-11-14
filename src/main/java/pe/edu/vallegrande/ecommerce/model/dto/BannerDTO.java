package pe.edu.vallegrande.ecommerce.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@ToString
public class BannerDTO {
    private String imageUrl;
    @NotEmpty
    private String title;
    @NotEmpty
    private String slug;
    @NotNull
    private Boolean grouped;
    private Map<String, Object> data;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}