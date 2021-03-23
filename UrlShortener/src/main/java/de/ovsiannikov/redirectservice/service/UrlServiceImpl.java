package de.ovsiannikov.redirectservice.service;

import com.google.common.hash.Hashing;
import de.ovsiannikov.redirectservice.dao.UrlRepository;
import de.ovsiannikov.redirectservice.entity.Url;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {

    UrlValidator validator = new UrlValidator(new String[]{"http", "https"});

    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    @Override
    public Url saveUrl(String url) {
        Url theUrl = new Url(generateShortUrl(url), url);
        return urlRepository.save(theUrl);

    }

    @Override
    public Url getUrl(Long id) {
        Url url = null;
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

    @Override
    public String getLongUrl(Long id) {

        String shortUrl;
        Optional<Url> optionalUrl = urlRepository.findById(id);
        if (optionalUrl.isPresent()) {
            shortUrl = optionalUrl.get().getLongUrl();
        } else {
            throw new RuntimeException("Url not found.");
        }
        return shortUrl;
    }

    private String generateShortUrl(String url) {

        String generatedShortUrl;

        if (validator.isValid(url) && url != null) {
            generatedShortUrl = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
        } else {
            throw new RuntimeException("Invalid url - " + url);
        }
        return generatedShortUrl;
    }


}
