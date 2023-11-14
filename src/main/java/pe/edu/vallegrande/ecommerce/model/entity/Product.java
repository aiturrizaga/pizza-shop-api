package pe.edu.vallegrande.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "image_url", nullable = false, length = 200)
    private String imageUrl;

    @Column(name = "rating")
    private Integer rating;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "slug", nullable = false, length = 100)
    private String slug;

    @Column(name = "price", nullable = false, precision = 10, scale = 5)
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

}