package lskim.accommodation_sample.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lskim.accommodation_sample.domain.enums.ImageType;
import lskim.accommodation_sample.domain.repository.ImageRepository;
import lskim.accommodation_sample.domain.repository.entities.ImageEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UploadService {

    private final ImageRepository imageRepository;

    public ImageEntity uploadAccommodationImage(ImageType imageType, MultipartFile multipartFile) throws IOException {
        final String fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
        final String fileDir = "tmpfile/accommodation/" + imageType.toString();
        final String filePath = fileDir + "/" + fileName;

        // 파일 경로 생성
        File destDir = new File(fileDir);
        // 기존 경로 검토
        if(!destDir.exists()) {
            // 신규 경로 생성
            destDir.mkdirs();
        }

        // 저장할 파일 객체 생성
        File destFile = new File(filePath);
        // 지정한 장소로 파일 전송 및 저장
        multipartFile.transferTo(destFile);

        // Entity 객체 생성
        ImageEntity imageEntity = ImageEntity.builder()
                .imageType(imageType) // 이미지 타입
                .path(filePath) // 이미지 경로
                .build(); // 생성

        return imageRepository.save(imageEntity);
    }

}
