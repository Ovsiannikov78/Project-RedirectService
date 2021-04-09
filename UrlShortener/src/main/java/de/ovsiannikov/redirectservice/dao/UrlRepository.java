package de.ovsiannikov.redirectservice.dao;

import de.ovsiannikov.redirectservice.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;


@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    Url findByShortUrl(String shortUrl);

    @Transactional
    Integer deleteUrlByExpirationDateBefore(LocalDateTime currentDate);
}
