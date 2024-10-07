package lskim.accommodation_sample.web.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AccommodationImageValidator.class)
public @interface ValidAccommodationImage {
    // 검증 실패시 표시할 메세지
    String message() default "이미지 등록 오류입니다.";
    // 유효성 그룹 지정
    Class<?>[] groups() default {};
    // 유효성 검사에 추가 데이터를 저장
    Class<? extends Payload>[] payload() default {};
}
