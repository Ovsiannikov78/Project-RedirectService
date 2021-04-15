package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.UrlRepository;
import de.ovsiannikov.redirectservice.entity.Url;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static de.ovsiannikov.redirectservice.prototype.UrlsPrototype.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UrlServiceImplTest {

    private final LocalDateTime testDate = LocalDateTime.of(2021,4,14,10,00,00);
    private final static LocalDateTime testDateFromUser = LocalDateTime.of(2021,8,10,12,00,00);
    private final static LocalDateTime testInvalidDateFromUser = LocalDateTime.of(2020,8,10,12,00,00);

    private  HelperService helperService;
    private  UrlRepository urlRepository;
    private  UrlService urlService;

    @BeforeEach
    void setUp(){
        urlRepository = mock(UrlRepository.class);
        helperService = new HelperService();
        urlService = new UrlServiceImpl(helperService,urlRepository);
    }

    @Test
    void testCreateUrlWithoutExpirationDateFromUser() {
        when(urlRepository.save(any())).thenReturn(urlWithoutExpirationDateFromUser());
        Url url = urlService.createUrl(longUrlDtoWithExpirationEqualsNull());
        assertThat(url).isNotNull();
        assertThat(url.getExpirationDate()).isEqualTo(testDate.plusDays(3));
        assertThat(url.getExpirationDate()).isAfter(testDate);
    }

    @Test
    void testCreateUrlWithExpirationDateFromUser() {
        when(urlRepository.save(any())).thenReturn(urlWithExpirationDateFromUser());
        Url url = urlService.createUrl(longUrlDtoWithExpirationDateFromUser(testDateFromUser));
        assertThat(url).isNotNull();
        assertThat(url.getExpirationDate()).isEqualTo(testDateFromUser);
        assertThat(url.getExpirationDate()).isAfter(testDate);
    }

    @Test
    void testCreateUrlWithInvalidExpirationDateFromUser() {
        when(urlRepository.save(any())).thenReturn(urlWithInvalidExpirationDateFromUser());
        Url url = urlService.createUrl(longUrlDtoWithExpirationDateFromUser(testInvalidDateFromUser));
        assertThat(url).isNotNull();
        assertThat(url.getExpirationDate()).isNotEqualTo(testDate);
        assertThat(url.getExpirationDate()).isBefore(testDate);
    }
}
