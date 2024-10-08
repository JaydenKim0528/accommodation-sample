package lskim.accommodation_sample.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lskim.accommodation_sample.domain.enums.AccommodationStatus;
import lskim.accommodation_sample.domain.enums.AccommodationType;
import lskim.accommodation_sample.domain.repository.entities.AccommodationEntity;

@Getter
@AllArgsConstructor
@Builder
public class Accommodation {
    private long id;
    private String name;
    private String description;
    private GeoLocation geoLocation;
    private AccommodationType type;
    private AccommodationStatus status;
    private ParkingInfo parkingInfo;
    private String locationGuideText;

    @Setter
    private String mainImagePath;

    public static Accommodation of(AccommodationEntity entity, String mainImagePath) {
        return Accommodation.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .geoLocation(new GeoLocation(entity.getLatitude(), entity.getLongitude()))
                .type(entity.getType())
                .parkingInfo(new ParkingInfo(entity.isFreeParking(), entity.getParkingType()))
                .locationGuideText(entity.getLocationGuideText())
                .mainImagePath(mainImagePath)
                .build();
    }

    public AccommodationEntity toSaveEntity() {
        return AccommodationEntity.builder()
                .name(this.name)
                .description(this.description)
                .latitude(this.geoLocation.getLatitude())
                .longitude(this.geoLocation.getLongitude())
                .type(this.type)
                .isFreeParking(this.parkingInfo.isFree())
                .parkingType(this.parkingInfo.getParkingType())
                .locationGuideText(this.locationGuideText)
                .build();
    }
}
