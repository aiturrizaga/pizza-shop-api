package pe.edu.vallegrande.ecommerce.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "order", schema = "public")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Size(max = 100)
    @NotNull
    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @NotNull
    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;

    @NotNull
    @Column(name = "amount_total", nullable = false, precision = 10, scale = 5)
    private BigDecimal amountTotal;

    @Size(max = 20)
    @NotNull
    @Column(name = "order_type", nullable = false, length = 20)
    private String orderType;

    @Size(max = 30)
    @NotNull
    @Column(name = "payment_method", nullable = false, length = 30)
    private String paymentMethod;

    @NotNull
    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Size(max = 20)
    @NotNull
    @Column(name = "state", nullable = false, length = 20)
    private String state;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OrderLine> orderLines = new LinkedHashSet<>();

}