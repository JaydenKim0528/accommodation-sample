package lskim.accommodation_sample.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ParkingType {
    FIELD("야외주차장"), LOT("대형주차장"), GARAGE("실내주차장"), STREET("길가주차");
    private String value;
}
