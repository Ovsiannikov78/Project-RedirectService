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

    // TODO можно ли Limit значения передать как парамметры

    @Query(value = "SELECT counter, short_url FROM `redirect-service`.redirect_statistic ORDER BY counter DESC Limit 0, 5;", nativeQuery = true)
    List<String> findTop5ShortUrl();


    // TODO доработать метод updateRedirectStatistic !!!

    @Modifying
    @Query(value = "insert into `redirect-service`.redirect_statistic (counter, long_url, short_url) VALUES(:counter" +
                   ",:long_url, :short_url) ON DUPLICATE KEY UPDATE counter=VALUES(counter) + redirect_statistic.counter ", nativeQuery = true)
    @Transactional
    void updateRedirectStatistic(@Param("counter") Long counter);
}
