package lskim.accommodation_sample.domain.service;

import lskim.accommodation_sample.domain.enums.ImageType;
import lskim.accommodation_sample.domain.exceptions.NotFoundImageException;
import lskim.accommodation_sample.domain.repository.ImageRepository;
import lskim.accommodation_sample.domain.repository.entities.AccommodationEntity;
import lskim.accommodation_sample.domain.repository.entities.ImageEntity;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import lskim.accommodation_sample.domain.exceptions.NotFoundAccommodationException;
import lskim.accommodation_sample.domain.model.Accommodation;
import lskim.accommodation_sample.domain.repository.AccommodationRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final ImageRepository imageRepository;

    @Transactional(readOnly = true)
    public Accommodation getName(long id) {
        AccommodationEntity accommodationEntity = accommodationRepository.findNameById(id).orElseThrow(NotFoundAccommodationException::new);
        return Accommodation.of(accommodationEntity);
    }
}
