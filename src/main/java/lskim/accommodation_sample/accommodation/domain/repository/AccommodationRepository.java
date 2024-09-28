package lskim.accommodation_sample.accommodation.domain.repository;

import lskim.accommodation_sample.accommodation.domain.repository.entity.AccommodationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccommodationRepository extends JpaRepository<AccommodationEntity, Long> {

    Optional<AccommodationEntity> findNameById(long id);

}
