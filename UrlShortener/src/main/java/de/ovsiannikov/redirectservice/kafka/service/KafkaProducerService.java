package de.ovsiannikov.redirectservice.kafka.service;

import de.ovsiannikov.redirectservice.dto.RedirectStatisticDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Data
@Service
public class KafkaProducerService {

    private final KafkaTemplate <String, RedirectStatisticDto> kafkaTemplate;

    @Value("${app.topic}")
    private String topic;

    public KafkaProducerService(KafkaTemplate <String, RedirectStatisticDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce (RedirectStatisticDto statisticDto) {
        System.out.println("Producing the statistic: " + statisticDto);
        kafkaTemplate.send(topic, statisticDto);
    }
}
