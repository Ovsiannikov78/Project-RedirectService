package de.ovsiannikov.redirectservice.dao;

import de.ovsiannikov.redirectservice.entity.RedirectStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<RedirectStatistic, Long> {

    RedirectStatistic getRedirectStatisticByShortUrl(String shortUrl);

    RedirectStatistic save(Optional<RedirectStatistic> redirectStatistic);

    @Query(value = "SELECT id, counter, short_url, long_url FROM `redirect-service`.redirect_statistic ORDER BY cast(counter as SIGNED) DESC Limit 0, 5;", nativeQuery = true)
    List<RedirectStatistic> findTop5ShortUrl();

    @Modifying
    @Query(value = "insert into `redirect-service`.redirect_statistic (counter, short_url, long_url) VALUES(:counter" +
                   ", :short_url,:long_url) ON DUPLICATE KEY UPDATE counter=VALUES(counter) + redirect_statistic.counter ", nativeQuery = true)
    @Transactional
    void updateRedirectStatistic(@Param("counter") Long counter,@Param("short_url") String shortUrl, @Param("long_url") String longUrl);
}
