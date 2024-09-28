package lskim.accommodation_sample.accommodation.web.common;

import lskim.accommodation_sample.accommodation.domain.repository.AccommodationRepository;
import lskim.accommodation_sample.accommodation.web.common.common.BaseMockMvcTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class AccommodationRestControllerTest extends BaseMockMvcTest {

    AccommodationRepository accommodationRepository;

    @Test
    @DisplayName("ID로 NAME 조회")
    void getName() throws Exception {

        final ResultActions actions = mockMvc.perform(get("/api/jpa/1").contentType(MediaType.APPLICATION_JSON));

        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("롯데호텔"));

    }

}