package lskim.accommodation_sample.domain.service;

import lombok.RequiredArgsConstructor;
import lskim.accommodation_sample.domain.enums.ImageType;
import lskim.accommodation_sample.domain.repository.ImageRepository;
import lskim.accommodation_sample.domain.repository.entities.ImageEntity;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
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
        final String fileDir = "temfile/accommodation/" + imageType.toString();
        final String filePath = fileDir + "/" + fileName;

        File desDir = new File(fileDir);
        if(!desDir.exists()) {
            desDir.mkdirs();
        }

        File destFile = new File(filePath);
        multipartFile.transferTo(destFile);

        ImageEntity imageEntity = ImageEntity.builder()
                .imageType(imageType)
                .path(filePath)
                .build();

        return imageRepository.save(imageEntity);
    }

}
