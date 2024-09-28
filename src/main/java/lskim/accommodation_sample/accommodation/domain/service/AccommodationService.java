package lskim.accommodation_sample.accommodation.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lskim.accommodation_sample.accommodation.domain.repository.AccommodationRepository;
import lskim.accommodation_sample.accommodation.domain.repository.entity.AccommodationEntity;
import lskim.accommodation_sample.accommodation.web.dto.Accommodation;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public Accommodation getName(long id) {
        AccommodationEntity accommodationEntity = accommodationRepository.findNameById(id).orElseThrow(() -> new RuntimeException()); // TODO exception 생성
        return Accommodation.of(accommodationEntity);
    }

}
