package pe.edu.vallegrande.ecommerce.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "person_address")
public class PersonAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "person_id", nullable = false)
    private Long userId;

    @NotNull
    @Size(max = 100)
    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @NotNull
    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @NotNull
    @Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

}