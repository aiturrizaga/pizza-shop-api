package pe.edu.vallegrande.ecommerce.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PageableDTO<T> {
    private List<T> content;
    private Integer totalPages;
    private Long totalElements;
    private Integer numberOfElements;
    private boolean first;
    private boolean last;
}
