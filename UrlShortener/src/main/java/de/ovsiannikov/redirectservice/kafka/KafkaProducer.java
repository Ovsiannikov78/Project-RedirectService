package de.ovsiannikov.redirectservice.kafka;

import de.ovsiannikov.redirectservice.dto.ShortUrlDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Data
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic}")
    private String topic;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(String message) {
        System.out.println("The producer sent a message: " + message);
        kafkaTemplate.send(topic, message);
    }
}
   /* private final KafkaTemplate <String, ShortUrlDto> kafkaTemplate;

    @Value("${app.topic}")
    private String topic;

    public KafkaProducer(KafkaTemplate <String, ShortUrlDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(ShortUrlDto shortUrlDto) {
        System.out.println("Producing the ShortUrlDto: " + shortUrlDto);
        kafkaTemplate.send(topic, shortUrlDto);
    }
}*/
