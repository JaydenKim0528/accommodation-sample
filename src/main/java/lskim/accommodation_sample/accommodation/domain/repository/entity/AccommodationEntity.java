package lskim.accommodation_sample.accommodation.domain.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accommodation")
@Getter
@NoArgsConstructor
public class AccommodationEntity {

    @Id // Primary Key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement 설정
    @Column(name = "no") // DB Column 지정
    private Long id;

    @Column(nullable = false, name = "acc_name") // DB Column 지정
    private String name;

    @Builder
    public AccommodationEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}