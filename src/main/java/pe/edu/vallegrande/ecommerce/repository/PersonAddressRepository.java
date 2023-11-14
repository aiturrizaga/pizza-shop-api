package pe.edu.vallegrande.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.ecommerce.model.entity.PersonAddress;

import java.util.List;

public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long> {
    List<PersonAddress> findAllByUserId(Long userId);
}
