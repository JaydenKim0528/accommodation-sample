package lskim.accommodation_sample.domain.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lskim.accommodation_sample.domain.enums.AccommodationType;
import lskim.accommodation_sample.domain.enums.ParkingType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "ACCOMMODATION")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccommodationEntity {

    @Id // 필드를 Primary Key로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement 설정
    @Column(name = "acmd_no", nullable = false) // 데이터베이스의 'acmd_no'라는 컬럼에 매핑
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    private double latitude;
    private double longitude;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccommodationType type;

    @Column(nullable = false)
    private boolean isFreeParking;

    @Enumerated(EnumType.STRING)
    private ParkingType parkingType;

    private String locationGuideText;


}