package de.ovsiannikov.redirectservice.controller;

import de.ovsiannikov.redirectservice.dto.StatisticDto;
import de.ovsiannikov.redirectservice.service.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }


    @GetMapping("/statistics")
    public ResponseEntity<List<StatisticDto>> getStatisticOfTheShortUrl () {

        return new ResponseEntity<>(statisticsService.getTheMostFrequentlyUsedShortUrls(), HttpStatus.OK);
    }
}
