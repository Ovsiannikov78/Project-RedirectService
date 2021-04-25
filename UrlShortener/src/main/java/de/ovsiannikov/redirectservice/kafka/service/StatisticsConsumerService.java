package de.ovsiannikov.redirectservice.kafka.service;

import de.ovsiannikov.redirectservice.dto.RedirectStatisticDto;
import de.ovsiannikov.redirectservice.service.StatisticsService;
import lombok.Data;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.List;

@Data
@Service
public class StatisticsConsumerService {

    private final static String topic = "redirect-statistic";
    private final static String groupId = "statistic";

    private final StatisticsService statisticsService;


    @KafkaListener(topics = topic, groupId = groupId, containerFactory = "kafkaListenerContainerFactory")
    public void listen(List<RedirectStatisticDto> statisticDto) {

        statisticsService.saveToDB(statisticDto);

          System.out.println("\n/******* The consumer received a statistic :  ---->>>>>>    ONE ********/\n"+statisticDto);
    }
}

