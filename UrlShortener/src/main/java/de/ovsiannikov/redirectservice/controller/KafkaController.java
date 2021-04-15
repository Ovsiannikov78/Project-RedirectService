package de.ovsiannikov.redirectservice.controller;

import de.ovsiannikov.redirectservice.entity.RedirectStatistic;
import de.ovsiannikov.redirectservice.kafka_service.StatisticsConsumerService;
import de.ovsiannikov.redirectservice.kafka_service.StatisticsProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class KafkaController {

    private final StatisticsConsumerService consumer;
    private final StatisticsProducerService producer;

    public KafkaController(StatisticsConsumerService consumer, StatisticsProducerService producer) {
        this.consumer = consumer;
        this.producer = producer;
    }

    @PostMapping("/send")
    public String send(@RequestBody RedirectStatistic statistic) {
        producer.produce(statistic);
        return "Your statistic was sent successfully !!!";
    }

    @GetMapping("/receive")
    public List<RedirectStatistic> receive() {
        return consumer.statisticList;
    }

}
