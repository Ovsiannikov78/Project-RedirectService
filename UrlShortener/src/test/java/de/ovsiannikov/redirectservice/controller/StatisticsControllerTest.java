package de.ovsiannikov.redirectservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ovsiannikov.redirectservice.service.StatisticsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static de.ovsiannikov.redirectservice.prototype.StatisticPrototypes.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
class StatisticsControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private StatisticsService statisticsService;

    @BeforeEach
    void setUp() {
        statisticsService = mock(StatisticsService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new StatisticsController(statisticsService)).build();
        objectMapper = new ObjectMapper();

    }

    @Test
    void testGetStatisticOfTheShortUrl() throws Exception {
        when(statisticsService.getTheMostFrequentlyUsedShortUrls()).thenReturn(top5ShortUrlList_3());

        mockMvc.perform(get("/statistics"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(top5ShortUrlList_3())));
    }
}
