package de.ovsiannikov.redirectservice.service;

import com.google.common.hash.Hashing;
import de.ovsiannikov.redirectservice.dao.UrlRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@Service
public class HelperService {

    private final UrlValidator validator = new UrlValidator(new String[]{"http", "https"});

    private final UrlRepository urlRepository;

    public HelperService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }


    public String generateShortUrl(String url) {

        String generatedShortUrl;

        if (validator.isValid(url) && url != null) {
            generatedShortUrl = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
        } else {
            throw new RuntimeException("Invalid url - " + url);
        }
        return generatedShortUrl;
    }

    public String createUrlExpirationDate(String expirationDate) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.GERMANY);

        if (expirationDate == null || expirationDate.isBlank()) {
            return LocalDateTime.now().plusDays(3).format(inputFormatter);
        } else {
            LocalDateTime dateTime = LocalDateTime.parse(expirationDate, inputFormatter);
            return dateTime.format(inputFormatter);
        }
    }
}
