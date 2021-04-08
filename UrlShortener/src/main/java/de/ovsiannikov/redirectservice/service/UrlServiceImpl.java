package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.UrlRepository;
import de.ovsiannikov.redirectservice.entity.Url;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
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
    public Url createUrl(String longUrl,Long customerNumber, LocalDateTime expirationDate) {

        Url url = new Url(helperService.generateShortUrl(), longUrl, 0, helperService.createUrlExpirationDate(expirationDate));
        return urlRepository.save(url);

    }

    // TODO do we need the isPresent() check here if we have a validator ???

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
