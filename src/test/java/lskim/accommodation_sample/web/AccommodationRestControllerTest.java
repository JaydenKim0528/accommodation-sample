package lskim.accommodation_sample.web;

import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import lskim.accommodation_sample.domain.repository.common.BaseMockMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
class AccommodationRestControllerTest extends BaseMockMvcTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("ID로 NAME 조회")
    void getName() throws Exception {
        final ResultActions resultActions = this.mockMvc.perform(
                get("/api/accommodation/1")
                        .contentType(MediaType.APPLICATION_JSON)
        );
        resultActions.andExpect(status().isOk());
    }
}