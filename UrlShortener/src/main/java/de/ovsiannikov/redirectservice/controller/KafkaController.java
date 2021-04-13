package de.ovsiannikov.redirectservice.controller;

import de.ovsiannikov.redirectservice.kafka.KafkaConsumer;
import de.ovsiannikov.redirectservice.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class KafkaController {

    private final KafkaConsumer consumer;
    private final KafkaProducer producer;

    public KafkaController(KafkaConsumer consumer, KafkaProducer producer) {
        this.consumer = consumer;
        this.producer = producer;
    }

    @PostMapping("/send")
    public String send(@RequestBody String message) {
        producer.produce(message);
        return "Your message was sent successfully !!!";
    }

    @GetMapping("/receive")
    public List<String> receive() {
        return consumer.messages;
    }

}
