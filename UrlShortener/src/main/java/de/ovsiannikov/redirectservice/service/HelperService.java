package de.ovsiannikov.redirectservice.service;

import com.google.common.hash.Hashing;
import de.ovsiannikov.redirectservice.dao.UrlRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (expirationDate == null || expirationDate.isBlank()) {
            return LocalDate.now().plusDays(3).format(inputFormatter);
        } else {
            LocalDate dateTime = LocalDate.parse(expirationDate, inputFormatter);
            return dateTime.format(inputFormatter);
        }
    }
}
