package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dto.RedirectStatisticDto;
import de.ovsiannikov.redirectservice.dto.StatisticDto;
import java.util.List;


public interface StatisticsService {

   void createOrUpdateRedirectStatisticInDB(List<RedirectStatisticDto> redirectStatisticDtoList);

   List<StatisticDto> getTheMostFrequentlyUsedShortUrls();
}
