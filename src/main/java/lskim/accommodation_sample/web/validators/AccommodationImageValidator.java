package lskim.accommodation_sample.web.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lskim.accommodation_sample.web.dto.AccommodationReq;

import java.util.List;

//public class AccommodationImageValidator implements ConstraintValidator<ValidAccommodationImage, List<AccommodationReq.ImageOnCreate>> {

    // 유효성 검사 초기화
//    @Override
//    public void initialize(ValidAccommodationImage constrainAnnotation) {
//        ConstraintValidator.super.initialize(constrainAnnotation);
//    }

    // 유효성 검사
//    @Override
//    public boolean isValid(List<AccommodationReq.ImageOnCreate> imageList, ConstraintValidatorContext context) {
//
//        // 이미지 리스트가 null이거나 비어 있으면 false
//        if (imageList == null || imageList.isEmpty()) {
//            return false;
//        }
//        // 이미지 리스트를 순회하며 각 요소의 타입이나 경로가 null인지 체크하여 null 값이 있으면 false 반환
//        for (AccommodationReq.ImageOnCreate image : imageList) {
//            if (image.getImageType() == null || image.getPath() == null) {
//                return false;
//            }
//        }
//        // 위 유효성 체크 항목들을 모두 통과하면 true 반환
//        return true;
//    }
//}
