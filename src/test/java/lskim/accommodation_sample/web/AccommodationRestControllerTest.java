package lskim.accommodation_sample.web;

import lskim.accommodation_sample.domain.enums.AccommodationType;
import lskim.accommodation_sample.domain.enums.ParkingType;
import lskim.accommodation_sample.domain.model.GeoLocation;
import lskim.accommodation_sample.domain.model.ParkingInfo;
import lskim.accommodation_sample.web.dto.AccommodationReq;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import lskim.accommodation_sample.domain.repository.common.BaseMockMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
class AccommodationRestControllerTest extends BaseMockMvcTest {

    @Autowired
    private ObjectMapper objectMapper;

    // 숙소 조회 테스트
    @Test
    @DisplayName("ID로 NAME 조회")
    void getName() throws Exception {
        final ResultActions resultActions = this.mockMvc.perform(
                get("/api/accommodation/1")
                        .contentType(MediaType.APPLICATION_JSON)
        );
        resultActions.andExpect(status().isOk());
    }

    // 숙소 등록 테스트
    @Test
    @DisplayName("숙소 등록")
    void insertAccommodation() throws Exception {
        String requestBody = objectMapper.writeValueAsString(
                AccommodationReq.Create.builder()
                        .name("CNC호텔")
                        .type(AccommodationType.HOTEL)
                        .locationGuideText("안양역 5분 거리에 위치한 럭셔리 호텔")
                        .geoLocation(new GeoLocation(37.4013094632175, 126.920381468542))
                        .parkingInfo(new ParkingInfo(true, ParkingType.GARAGE))
                        .description("럭셔리 호텔")
                        .build()
        );
        final ResultActions resultActions = this.mockMvc.perform(
                post("/api/accommodation/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        );
        resultActions.andExpect(status().isOk());
    }
}