package lskim.accommodation_sample.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccommodationType {
    HOTEL("HOTEL"), MOTEL("MOTEL"), RESORT("RESORT");
    private String value;
}
