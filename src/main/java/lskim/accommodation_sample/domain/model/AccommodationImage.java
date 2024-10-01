package lskim.accommodation_sample.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lskim.accommodation_sample.domain.enums.ImageType;
import lskim.accommodation_sample.domain.repository.entities.ImageEntity;

@Getter
@AllArgsConstructor
@Builder
public class AccommodationImage {
    private Long id;
    private ImageType imageType;
    private String path;
    private Long accommodationId;

    public ImageEntity toSaveEntity(long accommodationId) {
        return ImageEntity.builder()
                .accommodationId(accommodationId)
                .imageType(this.imageType)
                .path(this.path)
                .build();
    }
}
