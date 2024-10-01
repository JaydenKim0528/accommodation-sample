package lskim.accommodation_sample.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lskim.accommodation_sample.domain.enums.ImageType;
import lskim.accommodation_sample.domain.repository.entities.ImageEntity;
import lskim.accommodation_sample.domain.service.UploadService;
import lskim.accommodation_sample.web.common.BaseApiController;
import lskim.accommodation_sample.web.dto.AccommodationImageRes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ImageUploadRestController extends BaseApiController {

    private final UploadService uploadServicce;

    @PostMapping("/upload/image/accommodation")
    public AccommodationImageRes.Upload uploadImageForAccommodation (
            @RequestParam("imageType") ImageType imageType
            , @RequestParam("image") MultipartFile multipartFile ) throws IOException {

        if (multipartFile.isEmpty()) {
           throw new IllegalArgumentException("빈 파일입니다.");
        }
        ImageEntity imageEntity = uploadServicce.uploadAccommodationImage(imageType, multipartFile);
        return AccommodationImageRes.Upload.from(imageEntity);
    }
}
