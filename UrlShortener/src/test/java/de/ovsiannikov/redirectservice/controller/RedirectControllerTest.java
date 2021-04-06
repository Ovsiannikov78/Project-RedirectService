package de.ovsiannikov.redirectservice.controller;

import de.ovsiannikov.redirectservice.service.RedirectService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RedirectController.class)
class RedirectControllerTest {

    private final String shortUrl = "44ae9a04";
    private final String longUrl = "https://upload.wikimedia.org/wikipedia/commons/e/e4/Paris_July_2011-27a.jpg";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RedirectService redirectService;

    @Test
    void testRedirectToLongUrl() throws Exception {

        when(redirectService.getRedirectUrl(shortUrl))
                /*.thenReturn(Optional.of(longUrl));*/
                .thenReturn(Optional.of(longUrl));

        mockMvc.perform(get("/" + shortUrl))
                .andExpect(status().is3xxRedirection())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.header().string("Location", longUrl))
                .andReturn();
    }

    @Test
    void testRedirectUrlNotFound() throws Exception {

        when(redirectService.getRedirectUrl(shortUrl))
                .thenReturn(Optional.empty());

        mockMvc.perform(get("/" + shortUrl))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}

