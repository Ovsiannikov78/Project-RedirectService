/*package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.UrlRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Component
public class ExpiredUrlRemovalService {

    private final UrlRepository urlRepository;

    public ExpiredUrlRemovalService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Scheduled(fixedRate = 60000)
    public void deleteExpiredUrl() {

        urlRepository.deleteUrlByExpirationDateBefore(LocalDateTime.now());
    }
}*/
