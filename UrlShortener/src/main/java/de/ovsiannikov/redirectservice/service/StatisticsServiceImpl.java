package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.StatisticsRepository;
import de.ovsiannikov.redirectservice.dto.RedirectStatisticDto;
import de.ovsiannikov.redirectservice.entity.RedirectStatistic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private static final Logger logger = LogManager.getLogger(StatisticsServiceImpl.class);

    private final StatisticsRepository statisticsRepository;


    public StatisticsServiceImpl(StatisticsRepository statisticsRepository) {

        this.statisticsRepository = statisticsRepository;
    }

    // TODO доработать метод сохранения в базу RedirectStatistic object через JpaRepository method.


    @Override
    public RedirectStatistic saveToDB(List<RedirectStatisticDto> redirectStatisticDtoList) {

        RedirectStatistic redirectStatistic = null;

        logger.info("RedirectStatisticDto list from Consumer  - " + redirectStatisticDtoList);

        Map<RedirectStatisticDto, Long> redirectStatisticDtoMap = redirectStatisticDtoList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        logger.info("RedirectStatistic Map  - " + redirectStatisticDtoMap);

        for (Map.Entry<RedirectStatisticDto, Long> entry : redirectStatisticDtoMap.entrySet()) {

            logger.info(" \n" + "Entry from Map  - " + redirectStatisticDtoMap + " \n");

            if (statisticsRepository.getRedirectStatisticByShortUrl(entry.getKey().getShortUrl()) == null) {

                redirectStatistic = new RedirectStatistic(entry.getKey().getShortUrl(),
                        entry.getKey().getLongUrl(),
                        entry.getValue());
                statisticsRepository.save(redirectStatistic);

                logger.info("NEW RedirectStatistic saved to DB - " + redirectStatistic);

            } else {

                redirectStatistic = statisticsRepository.getRedirectStatisticByShortUrl(entry.getKey().getShortUrl());
                redirectStatistic.setCounter(redirectStatistic.getCounter() + entry.getValue());
                statisticsRepository.save(redirectStatistic);

                logger.info("UPDATED RedirectStatistic saved to DB - " + redirectStatistic);
            }
        }
        return redirectStatistic;
    }


    @Override
    public List<String> getTheMostFrequentlyUsedShortUrls() {
        return statisticsRepository.findTop5ShortUrl();
    }
}
