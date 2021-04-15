package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.UrlRepository;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;


@Service
public class HelperService {

    private static final SecureRandom random = new SecureRandom();
    private static final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

    public String generateShortUrl() {
        byte[] buffer = new byte[8];
        random.nextBytes(buffer);
        return encoder.encodeToString(buffer);
    }

    public LocalDateTime createUrlExpirationDate(LocalDateTime expirationDate) {

        if (expirationDate == null) {
            return LocalDateTime.now().plusMinutes(3);  //with minutes for testing only
        } else {
            return LocalDateTime.parse(expirationDate.toString());
        }
    }
}
