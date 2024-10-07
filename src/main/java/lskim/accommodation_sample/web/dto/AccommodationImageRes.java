package lskim.accommodation_sample.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lskim.accommodation_sample.domain.enums.ImageType;
import lskim.accommodation_sample.domain.repository.entities.ImageEntity;

@Getter
public class AccommodationImageRes {

    @Getter
    @AllArgsConstructor
    public static class Upload {
        private Long id;
        private ImageType imageType;
        private String path;

        public static Upload from(ImageEntity imageEntity) {
            return new Upload(imageEntity.getId(), imageEntity.getImageType(), imageEntity.getPath());
        }
    }
}
