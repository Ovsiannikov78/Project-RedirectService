package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.UrlRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RedirectServiceImpl implements RedirectService {

    private final UrlRepository urlRepository;

    public RedirectServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Optional<String> getRedirectUrl(String shortUrl) {

        LocalDateTime expirationDate = urlRepository.findByShortUrl(shortUrl).getExpirationDate();
        LocalDateTime currentDate = LocalDateTime.now();

        if (!shortUrl.isBlank() && currentDate.isBefore(expirationDate)) {
            return Optional.ofNullable(urlRepository.findByShortUrl(shortUrl).getLongUrl());
        }
        return Optional.empty();
    }
}

