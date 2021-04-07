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

    // TODO add id for unique short url

    public String generateShortUrl(String longUrl) {

        String generatedShortUrl;

        if (validator.isValid(longUrl) && longUrl != null) {
            generatedShortUrl = Hashing.murmur3_32().hashString(longUrl, StandardCharsets.UTF_8).toString();
        } else {
            throw new RuntimeException("Invalid url - " + longUrl);
        }
        return generatedShortUrl;
    }

    public LocalDateTime createUrlExpirationDate(LocalDateTime expirationDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.GERMANY);

        if (expirationDate == null) {
            return LocalDateTime.parse(LocalDateTime.now().plusMinutes(3).format(formatter),formatter) ;  //with minutes for testing only
        } else {
            return LocalDateTime.parse(expirationDate.toString(), formatter);
        }
    }
}
