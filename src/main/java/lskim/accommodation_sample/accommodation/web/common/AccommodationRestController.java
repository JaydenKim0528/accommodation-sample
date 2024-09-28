package lskim.accommodation_sample.accommodation.web.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lskim.accommodation_sample.accommodation.domain.service.AccommodationService;
import lskim.accommodation_sample.accommodation.web.dto.Accommodation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccommodationRestController {

    private final AccommodationService accommodationService;

    @GetMapping("/jpa/{id}")
    public Accommodation jpaConnection(@PathVariable("id") long id) {
        return accommodationService.getName(id);
    }



}
