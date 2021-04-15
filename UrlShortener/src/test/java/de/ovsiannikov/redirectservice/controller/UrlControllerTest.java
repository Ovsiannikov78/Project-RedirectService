package de.ovsiannikov.redirectservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ovsiannikov.redirectservice.dto.LongUrlDto;
import de.ovsiannikov.redirectservice.service.UrlService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static de.ovsiannikov.redirectservice.prototype.UrlsPrototype.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
class UrlControllerTest {

    MockMvc mockMvc;
    ObjectMapper objectMapper;
    UrlService urlService;

    @BeforeEach
    void setUp() {
        urlService = mock(UrlService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new UrlController(urlService)).build();
        objectMapper = new ObjectMapper();

    }

    @Test
    void testCreateShortUrlDto() throws Exception {
        when(urlService.createShortUrlDto(any())).thenReturn(shortUrlDto());
        mockMvc.perform(post("/urls")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(longUrlDtoWithExpirationEqualsNull())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(shortUrlDto())));


        ArgumentCaptor<LongUrlDto> longUrlDtoCaptor = ArgumentCaptor.forClass(LongUrlDto.class);
        Mockito.verify(urlService).createShortUrlDto(longUrlDtoCaptor.capture());
        LongUrlDto longUrlDto = longUrlDtoCaptor.getValue();
        Assertions.assertEquals(longUrlDtoWithExpirationEqualsNull(), longUrlDto);
    }
}
