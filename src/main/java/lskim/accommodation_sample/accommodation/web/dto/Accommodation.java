package lskim.accommodation_sample.accommodation.web.dto;

import lombok.Builder;
import lombok.Getter;
import lskim.accommodation_sample.accommodation.domain.repository.entity.AccommodationEntity;

@Getter
public class Accommodation {

    private long id;
    private String name;

    @Builder
    public Accommodation (long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Accommodation of(AccommodationEntity entity) {
        return Accommodation.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
