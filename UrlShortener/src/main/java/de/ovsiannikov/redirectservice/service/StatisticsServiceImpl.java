package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.StatisticsRepository;
import de.ovsiannikov.redirectservice.dto.RedirectStatisticDto;
import de.ovsiannikov.redirectservice.dto.StatisticDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final Logger logger = LogManager.getLogger(StatisticsServiceImpl.class);

    private final StatisticsRepository statisticsRepository;


    public StatisticsServiceImpl(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public void createOrUpdateRedirectStatisticInDB(List<RedirectStatisticDto> redirectStatisticDtoList) {

        Map<RedirectStatisticDto, Long> redirectStatisticDtoMap = redirectStatisticDtoList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<RedirectStatisticDto, Long> entry : redirectStatisticDtoMap.entrySet()) {

            statisticsRepository.updateRedirectStatistic(entry.getValue(), entry.getKey().getShortUrl(),
                    entry.getKey().getLongUrl());
        }
    }


    @Override
    public List<StatisticDto> getTheMostFrequentlyUsedShortUrls() {

        return statisticsRepository.findTop5ShortUrl()
                .stream()
                .map(list -> new StatisticDto(list.getCounter(), list.getShortUrl(), list.getLongUrl()))
                .collect(Collectors.toList());
    }
}
