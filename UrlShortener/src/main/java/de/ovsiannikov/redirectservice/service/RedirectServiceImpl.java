package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.UrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class RedirectServiceImpl implements RedirectService {

    private final UrlRepository urlRepository;

    public RedirectServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Optional<String> getRedirectUrl(String shortUrl) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate expirationDate = LocalDate.from(formatter.parse(urlRepository.findByShortUrl(shortUrl).getExpirationDate()));
        LocalDate currentDate = LocalDate.now();

        if (!shortUrl.isBlank() && currentDate.isBefore(expirationDate)) {
            return Optional.ofNullable(urlRepository.findByShortUrl(shortUrl).getLongUrl());
        }
        return Optional.empty();
    }
}

