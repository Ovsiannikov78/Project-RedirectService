package de.ovsiannikov.redirectservice.service;

import de.ovsiannikov.redirectservice.dao.StatisticsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static de.ovsiannikov.redirectservice.prototype.StatisticPrototypes.*;
import static org.mockito.Mockito.*;

class StatisticsServiceImplTest {

    private StatisticsRepository statisticsRepository;
    private StatisticsService statisticsService;

    @BeforeEach
    void setUp(){
        statisticsRepository = mock(StatisticsRepository.class);
        statisticsService = new StatisticsServiceImpl(statisticsRepository);
    }

    @Test
    void createOrUpdateRedirectStatisticInDB_EmptyList() {
        statisticsService.createOrUpdateRedirectStatisticInDB(Collections.unmodifiableList(redirectStatisticDtoListFromKafka()));
        verify(statisticsRepository,times(0)).updateRedirectStatistic(anyLong(),anyString(),anyString());
    }


    @Test
    void createOrUpdateRedirectStatisticInDB_1() {
        statisticsService.createOrUpdateRedirectStatisticInDB(Collections.unmodifiableList(redirectStatisticDtoListFromKafka_1()));
        verify(statisticsRepository,times(1)).updateRedirectStatistic(3L,"abc","microsoft");
    }

    @Test
    void createOrUpdateRedirectStatisticInDB_2() {
        statisticsService.createOrUpdateRedirectStatisticInDB(redirectStatisticDtoListFromKafka_2());
        verify(statisticsRepository,times(1)).updateRedirectStatistic(3L,"abc","microsoft");
        verify(statisticsRepository,times(1)).updateRedirectStatistic(2L,"ekl","google");
    }

    @Test
    void createOrUpdateRedirectStatisticInDB_3() {
        statisticsService.createOrUpdateRedirectStatisticInDB(redirectStatisticDtoListFromKafka_3());
        verify(statisticsRepository,times(1)).updateRedirectStatistic(1L,"abc","microsoft");
        verify(statisticsRepository,times(1)).updateRedirectStatistic(2L,"ekl","google");
        verify(statisticsRepository,times(1)).updateRedirectStatistic(4L,"mno","apple");
    }

}
