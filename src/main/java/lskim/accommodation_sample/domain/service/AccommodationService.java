package lskim.accommodation_sample.domain.service;

import jakarta.validation.constraints.NotNull;
import lskim.accommodation_sample.domain.enums.ImageType;
import lskim.accommodation_sample.domain.exceptions.NotFoundImageException;
import lskim.accommodation_sample.domain.model.AccommodationImage;
import lskim.accommodation_sample.domain.repository.ImageRepository;
import lskim.accommodation_sample.domain.repository.entities.AccommodationEntity;
import lskim.accommodation_sample.domain.repository.entities.ImageEntity;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import lskim.accommodation_sample.domain.exceptions.NotFoundAccommodationException;
import lskim.accommodation_sample.domain.model.Accommodation;
import lskim.accommodation_sample.domain.repository.AccommodationRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final ImageRepository imageRepository;

    @Transactional(readOnly = true)
    public Accommodation getName(long id) {
        // 검색 조건 값을 조회
        AccommodationEntity accommodationEntity = accommodationRepository.findNameById(id).orElseThrow(NotFoundAccommodationException::new);
        // 검색 조건에 해당하는 메인 이미지 조회
        ImageEntity mainImageEntity = imageRepository.findByAccommodationIdAndImageType(id, ImageType.MAIN).orElseThrow(NotFoundImageException::new);
        return Accommodation.of(accommodationEntity, mainImageEntity.getPath());
    }

    @Transactional
    public Accommodation save(Accommodation accommodation, List<AccommodationImage> imageList) {
        AccommodationEntity savedAccommodationEntity = accommodationRepository.save(accommodation.toSaveEntity());

        // 신규 숙박시설을 등록한 등록번호 추출
        long accommodationId = savedAccommodationEntity.getId();

        // 입력한 이미지 배열화
        List<ImageEntity> imageEntities = imageList.stream()
                .map(accommodationImage -> accommodationImage.toSaveEntity(accommodationId))
                .toList();

        // 이미지 등록
        Iterable<ImageEntity> savedImageEntities = imageRepository.saveAll(imageEntities);

        // 메인 이미지 경로 추출
        String mainImagePath = StreamSupport.stream(savedImageEntities.spliterator(), false)
                .filter(imageEntity -> imageEntity.getImageType().equals(ImageType.MAIN))
                .map(ImageEntity::getPath)
                .findFirst().orElse("/img/default_main_img.jpg");

        return Accommodation.of(savedAccommodationEntity, mainImagePath);
    }
}
