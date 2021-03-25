package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectServiceImpl implements RedirectService {

    private final UrlRepository urlRepository;

    public RedirectServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Optional<String> getRedirectUrl(String shortUrl) {
        Optional<String> longUrl;

        if (!shortUrl.isBlank()) {
            longUrl = Optional.ofNullable(urlRepository.findByShortUrl(shortUrl).getLongUrl());
        } else {
            return Optional.empty();
        }
        return longUrl;
    }
}

