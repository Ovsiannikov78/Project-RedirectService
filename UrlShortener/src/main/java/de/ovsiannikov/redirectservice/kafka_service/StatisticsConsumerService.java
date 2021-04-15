package de.ovsiannikov.redirectservice.kafka_service;

import de.ovsiannikov.redirectservice.entity.RedirectStatistic;
import lombok.Data;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
@Data
public class StatisticsConsumerService {
    public final List<RedirectStatistic> statisticList = new ArrayList<>();
    private final static String topic = "redirect-statistic";
    private final static String groupId = "statistic";

    @KafkaListener(topics = topic, groupId = groupId)
    public void listen(RedirectStatistic statistic) {
        statisticList.add(statistic);
        System.out.println("The consumer received a statistic : " + statistic);
    }
}
