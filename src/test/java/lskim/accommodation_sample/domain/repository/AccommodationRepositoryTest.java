package lskim.accommodation_sample.domain.repository;

import lskim.accommodation_sample.domain.enums.AccommodationType;
import lskim.accommodation_sample.domain.enums.ParkingType;
import lskim.accommodation_sample.domain.model.GeoLocation;
import lskim.accommodation_sample.domain.model.ParkingInfo;
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

    // 숙소 조회 테스트
    @Test
    void getNamefromDB() {
        AccommodationEntity accommodationEntity = accommodationRepository.findById(1L).orElseThrow(NotFoundAccommodationException::new);
        assertThat(accommodationEntity.getName()).isEqualTo("서울 호텔");
    }

    // 숙소 등록 테스트
    @Test
    void insertAccommodationtoDB() {
        AccommodationEntity accommodationEntity = AccommodationEntity.builder()
                .name("CNC호텔")
                .type(AccommodationType.HOTEL)
                .locationGuideText("안양역 5분 거리에 위치한 럭셔리 호텔")
                .latitude(37.4013094632175)
                .longitude(126.920381468542)
                .parkingType(ParkingType.GARAGE)
                .description("럭셔리 호텔")
                .build();

        AccommodationEntity saved = accommodationRepository.save(accommodationEntity);
        assertThat(saved.getName()).isEqualTo(accommodationEntity.getName());
    }
}
