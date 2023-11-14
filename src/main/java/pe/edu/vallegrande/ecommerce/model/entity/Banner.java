package pe.edu.vallegrande.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "banner")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "image_url", nullable = false, length = 200)
    private String imageUrl;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "slug", nullable = false, length = 100)
    private String slug;

    @Column(name = "grouped", nullable = false)
    private Boolean grouped = false;

    @Column(name = "data", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> data;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

}