package pe.edu.vallegrande.ecommerce.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Size(max = 100)
    @Column(name = "description", length = 100)
    private String description;

    @NotNull
    @Size(max = 100)
    @Column(name = "slug", nullable = false, length = 100)
    private String slug;

    @Column(name = "shortcut")
    private Boolean shortcut = false;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active = true;

}