package lskim.accommodation_sample.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccommodationStatus {
    AVAILABLE("AVAILABLE"), HOLDING("HOLDING"), DELETED("DELETED");
    private String status;
}
