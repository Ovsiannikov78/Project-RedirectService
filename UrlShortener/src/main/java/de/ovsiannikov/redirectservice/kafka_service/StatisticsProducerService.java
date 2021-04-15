package de.ovsiannikov.redirectservice.kafka_service;

import de.ovsiannikov.redirectservice.entity.RedirectStatistic;
import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Data
public class StatisticsProducerService {

    private final KafkaTemplate <String, RedirectStatistic> kafkaTemplate;

    @Value("${app.topic}")
    private String topic;

    public StatisticsProducerService(KafkaTemplate<String, RedirectStatistic> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(RedirectStatistic statistic) {
        System.out.println("Producing the statistic: " + statistic);
        kafkaTemplate.send(topic, statistic);
    }
}
