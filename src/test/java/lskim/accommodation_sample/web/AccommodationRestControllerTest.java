package lskim.accommodation_sample.web;

import lskim.accommodation_sample.domain.enums.AccommodationType;
import lskim.accommodation_sample.domain.enums.ImageType;
import lskim.accommodation_sample.domain.enums.ParkingType;
import lskim.accommodation_sample.domain.model.GeoLocation;
import lskim.accommodation_sample.domain.model.ParkingInfo;
import lskim.accommodation_sample.jwt.auth.LoginUser;
import lskim.accommodation_sample.jwt.util.JwtUtil;
import lskim.accommodation_sample.web.dto.AccommodationReq;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import lskim.accommodation_sample.domain.repository.common.BaseMockMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
class AccommodationRestControllerTest extends BaseMockMvcTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtUtil jwtUtil;

    private LoginUser user = new LoginUser(1L, "sample");

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
                        .imageList(Arrays.asList(
                                AccommodationReq.ImageOnCreate.builder().imageType(ImageType.MAIN).path("/img/1.jpg").build()
                                ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.THUMBNAIL).path("/img/2.jpg").build()
                                ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.DETAIL).path("/img/3.jpg").build()
                        ))
                        .build()
        );
        final ResultActions resultActions = this.mockMvc.perform(
                post("/api/accommodation/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        );
        resultActions.andExpect(status().isOk());
    }

    // 숙소 등록 테스트
    @Test
    @DisplayName("숙소 등록")
    void insertAccommodationNotName() throws Exception {
        String requestBody = objectMapper.writeValueAsString(
                AccommodationReq.Create.builder()
                        .name("")
                        .type(AccommodationType.HOTEL)
                        .locationGuideText("안양역 5분 거리에 위치한 럭셔리 호텔")
                        .geoLocation(new GeoLocation(37.4013094632175, 126.920381468542))
                        .parkingInfo(new ParkingInfo(true, ParkingType.GARAGE))
                        .description("럭셔리 호텔")
                        .imageList(Arrays.asList(
                                AccommodationReq.ImageOnCreate.builder().imageType(ImageType.MAIN).path("/img/1.jpg").build()
                                ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.THUMBNAIL).path("/img/2.jpg").build()
                                ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.DETAIL).path("/img/3.jpg").build()
                        ))
                        .build()
        );
        final ResultActions resultActions = this.mockMvc.perform(
                post("/api/accommodation/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        );
        resultActions.andExpect(status().isOk());
    }

    // 숙소 등록 테스트
    @Test
    @DisplayName("숙소 등록")
    void insertAccommodationErrorImageType() throws Exception {
        String requestBody = objectMapper.writeValueAsString(
                AccommodationReq.Create.builder()
                        .name("CNC호텔")
                        .type(AccommodationType.HOTEL)
                        .locationGuideText("안양역 5분 거리에 위치한 럭셔리 호텔")
                        .geoLocation(new GeoLocation(37.4013094632175, 126.920381468542))
                        .parkingInfo(new ParkingInfo(true, ParkingType.GARAGE))
                        .description("럭셔리 호텔")
                        .imageList(Arrays.asList(
                                AccommodationReq.ImageOnCreate.builder().imageType(ImageType.MAIN).path("").build()
                                ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.THUMBNAIL).path("/img/2.jpg").build()
                                ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.DETAIL).path("/img/3.jpg").build()
                        ))
                        .build()
        );
        final ResultActions resultActions = this.mockMvc.perform(
                post("/api/accommodation/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        );
        resultActions.andExpect(status().isOk());
    }

//    -----------------------------------------------------------------------------------------------------------------

    @Test
    @DisplayName("토큰 확인")
    void tokenCheck() throws Exception {
        // LoginUser 객체를 직접 설정
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String testAccessToken = jwtUtil.createAccessToken(user);

        final ResultActions actions = mockMvc.perform(get("/api/login-user")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + testAccessToken)
        );

        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.userNo").value(user.getUserNo()))
                .andExpect(jsonPath("$.userId").value(user.getUserId()));
    }

}