package lskim.accommodation_sample.domain.repository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import lskim.accommodation_sample.domain.exceptions.NotFoundAccommodationException;
import lskim.accommodation_sample.domain.repository.entities.AccommodationEntity;
import lskim.accommodation_sample.domain.repository.common.BaseJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
class AccommodationRepositoryTest extends BaseJpaTest {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Test
    void getNamefromDB() {
        AccommodationEntity accommodationEntity = accommodationRepository.findById(1L).orElseThrow(NotFoundAccommodationException::new);
        assertThat(accommodationEntity.getName()).isEqualTo("서울 호텔");
    }

}
