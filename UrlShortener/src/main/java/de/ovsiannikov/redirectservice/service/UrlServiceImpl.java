package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.UrlRepository;
import de.ovsiannikov.redirectservice.dto.LongUrlDto;
import de.ovsiannikov.redirectservice.dto.ShortUrlDto;
import de.ovsiannikov.redirectservice.entity.Url;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {

    private final HelperService helperService;
    private final UrlRepository urlRepository;

    public UrlServiceImpl(HelperService helperService, UrlRepository urlRepository) {
        this.helperService = helperService;
        this.urlRepository = urlRepository;
    }

    @Override
    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    @Override
    public Url createUrl(LongUrlDto longUrlDto) {

        Url url = new Url(helperService.generateShortUrl(), longUrlDto.getLongUrl(), 0,
                helperService.createUrlExpirationDate(longUrlDto.getExpirationDate()));
        return urlRepository.save(url);

    }

    @Override
    public ShortUrlDto createShortUrlDto(LongUrlDto longUrlDto) {
        Url url = createUrl(longUrlDto);
        return new ShortUrlDto(url.getId(), url.getShortUrl());

    }

    @Override
    public Url getUrl(Long id) {
        Url url;
        Optional<Url> optionalUrl = urlRepository.findById(id);
        if (optionalUrl.isPresent()) {
            url = optionalUrl.get();
        } else {
            throw new RuntimeException("Url not found.");
        }
        return url;
    }

    @Override
    public void deleteUrl(Long id) {
        urlRepository.deleteById(id);
    }
}
