package lskim.accommodation_sample.domain.repository;

import lskim.accommodation_sample.domain.enums.ImageType;
import lskim.accommodation_sample.domain.repository.entities.ImageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ImageRepository extends CrudRepository<ImageEntity, Long> {
    Optional<ImageEntity> findByAccommodationIdAndImageType(Long accommodationId, ImageType imageType);
}
