package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dto.RedirectStatisticDto;
import de.ovsiannikov.redirectservice.entity.RedirectStatistic;
import java.util.List;


public interface StatisticsService {

   RedirectStatistic saveToDB(List<RedirectStatisticDto> redirectStatisticDtoList);

   List<String> getTheMostFrequentlyUsedShortUrls();
}
