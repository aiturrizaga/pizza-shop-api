package pe.edu.vallegrande.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pe.edu.vallegrande.ecommerce.model.entity.Person;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByUuid(UUID uuid);

    @Modifying
    @Query(value = "update Person p set p.verified = true where p.uuid = ?1")
    void verifyEmailByUUID(UUID uuid);

    @Modifying
    @Query(value = "update Person p set p.active = false where p.id = ?1")
    void disableById(Long id);
}
