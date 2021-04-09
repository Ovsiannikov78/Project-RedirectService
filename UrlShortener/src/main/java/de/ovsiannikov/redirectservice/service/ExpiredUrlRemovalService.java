package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.UrlRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Component
public class ExpiredUrlRemovalService {

    private static final Logger logger = LogManager.getLogger(ExpiredUrlRemovalService.class);

    private final UrlRepository urlRepository;

    public ExpiredUrlRemovalService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Scheduled(fixedRate = 60000)
    public void deleteExpiredUrl() {

       Integer quantityRemovedUrls = urlRepository.deleteUrlByExpirationDateBefore(LocalDateTime.now());
        logger.info("Quantity of removed expired Urls is - " + quantityRemovedUrls);
    }
}
