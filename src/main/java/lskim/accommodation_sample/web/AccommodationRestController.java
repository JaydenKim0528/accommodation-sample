package lskim.accommodation_sample.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lskim.accommodation_sample.domain.service.AccommodationService;
import lskim.accommodation_sample.web.common.BaseApiController;
import lskim.accommodation_sample.domain.model.Accommodation;
import lskim.accommodation_sample.web.dto.AccommodationReq;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
public class AccommodationRestController extends BaseApiController {

    private final AccommodationService accommodationService;

    @GetMapping("/accommodation/{id}")
    public Accommodation getAccommodationById(@PathVariable("id") long id) {
        return accommodationService.getName(id);
    }

    @PostMapping("/accommodation/insert")
    public Accommodation accommodationInsert(@RequestBody @Valid AccommodationReq.Create accommodationReqCreate) {
        log.info("Insert : {}", accommodationReqCreate);
        return null;
    }
}
