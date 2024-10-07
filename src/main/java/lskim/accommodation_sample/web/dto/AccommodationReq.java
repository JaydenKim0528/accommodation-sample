package lskim.accommodation_sample.web.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lskim.accommodation_sample.domain.enums.AccommodationStatus;
import lskim.accommodation_sample.domain.enums.AccommodationType;
import lskim.accommodation_sample.domain.enums.ImageType;
import lskim.accommodation_sample.domain.model.GeoLocation;
import lskim.accommodation_sample.domain.model.ParkingInfo;
import lskim.accommodation_sample.web.validators.ValidAccommodationImage;

import java.util.List;

@Getter
public class AccommodationReq {

    @Getter
    public static class Create {

        @NotBlank(message = "숙소 이름은 필수입니다.")
        private String name;

        private String description;

        @NotNull
        private GeoLocation geoLocation;

        @NotNull
        private AccommodationType type;

        @NotNull
        private AccommodationStatus status;

        @NotNull
        private ParkingInfo parkingInfo;

        private String locationGuideText;

        @NotNull
        @ValidAccommodationImage
        private List<ImageOnCreate> imageList;

        @Builder
        @JsonCreator
        public Create(
                @JsonProperty("name") String name,
                @JsonProperty("description") String description,
                @JsonProperty("geoLocation") GeoLocation geoLocation,
                @JsonProperty("type") AccommodationType type,
                @JsonProperty("parkingInfo") ParkingInfo parkingInfo,
                @JsonProperty("locationGuideText") String locationGuideText,
                @JsonProperty("imageList") List<ImageOnCreate> imageList) {
            this.name = name;
            this.description = description;
            this.geoLocation = geoLocation;
            this.type = type;
            this.status = AccommodationStatus.AVAILABLE;
            this.parkingInfo = parkingInfo;
            this.locationGuideText = locationGuideText;
            this.imageList = imageList;
        }
    }

    @Getter
    public static class ImageOnCreate {
        private ImageType imageType;
        private String path;

        @Builder
        @JsonCreator
        public ImageOnCreate(@JsonProperty("imageType") ImageType imageType,
                             @JsonProperty("path") String path) {
            this.imageType = imageType;
            this.path = path;
        }
    }
}
