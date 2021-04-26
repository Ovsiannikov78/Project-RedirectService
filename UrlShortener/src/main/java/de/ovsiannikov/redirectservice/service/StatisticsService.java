package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dto.RedirectStatisticDto;
import java.util.List;


public interface StatisticsService {

   void createOrUpdateRedirectStatisticInDB(List<RedirectStatisticDto> redirectStatisticDtoList);

   List<String> getTheMostFrequentlyUsedShortUrls();
}
