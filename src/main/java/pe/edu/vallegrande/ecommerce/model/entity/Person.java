package pe.edu.vallegrande.ecommerce.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "uuid", nullable = false)
    private UUID uuid = UUID.randomUUID();

    @NotNull
    @Size(max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @NotNull
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Size(max = 10)
    @Column(name = "phone", length = 10)
    private String phone;

    @Size(max = 50)
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Size(max = 50)
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @NotNull
    @Column(name = "verified", nullable = false)
    private Boolean verified = false;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active = true;

}