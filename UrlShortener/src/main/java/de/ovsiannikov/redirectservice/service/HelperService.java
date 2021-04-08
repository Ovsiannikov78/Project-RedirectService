package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.UrlRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Locale;


@Service
public class HelperService {

    private static final SecureRandom random = new SecureRandom();
    private static final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

    private final UrlValidator validator = new UrlValidator(new String[]{"http", "https"});

    private final UrlRepository urlRepository;

    public HelperService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String generateShortUrl() {
        byte[] buffer = new byte[8];
        random.nextBytes(buffer);
        return encoder.encodeToString(buffer);
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
