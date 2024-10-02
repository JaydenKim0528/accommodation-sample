package lskim.accommodation_sample.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lskim.accommodation_sample.domain.enums.ParkingType;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingInfo {
    private boolean isFree;
    private ParkingType parkingType;
}
