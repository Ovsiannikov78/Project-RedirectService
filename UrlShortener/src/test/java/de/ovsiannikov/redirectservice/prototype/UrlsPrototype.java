package de.ovsiannikov.redirectservice.prototype;

import de.ovsiannikov.redirectservice.dto.LongUrlDto;
import de.ovsiannikov.redirectservice.entity.Url;

import java.time.LocalDateTime;

public class UrlsPrototype {

    private final static LocalDateTime testCurrentDate = LocalDateTime.of(2021,4,14,10,00,00);
    private final static LocalDateTime testDateFromUser = LocalDateTime.of(2021,8,10,12,00,00);

    public static Url testUrlWithoutExpirationDateFromUser() {
        Url url = new Url();
        url.setId(1L);
        url.setCustomerNumber(0);
        url.setShortUrl("test123");
        url.setLongUrl("https://www.test123");
        url.setExpirationDate(testCurrentDate.plusDays(3));
        return url;
    }

    public static Url testUrlWithExpirationDateFromUser() {
        Url url = new Url();
        url.setId(1L);
        url.setCustomerNumber(0);
        url.setShortUrl("test123");
        url.setLongUrl("https://www.test123");
        url.setExpirationDate(testDateFromUser);
        return url;
    }

    public static LongUrlDto testLongUrlDtoWithExpirationEqualsNull() {
        LongUrlDto longUrlDto = new LongUrlDto();
        longUrlDto.setCustomerNumber(0L);
        longUrlDto.setLongUrl("https://www.test123");
        longUrlDto.setExpirationDate(null);
        return longUrlDto;
    }


    public static LongUrlDto testLongUrlDtoWithExpirationDateFromUser(LocalDateTime testDateFromUser) {
        LongUrlDto longUrlDto = new LongUrlDto();
        longUrlDto.setCustomerNumber(0L);
        longUrlDto.setLongUrl("https://www.test123");
        longUrlDto.setExpirationDate(testDateFromUser);
        return longUrlDto;
    }
}
