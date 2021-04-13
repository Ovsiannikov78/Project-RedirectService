package de.ovsiannikov.redirectservice.kafka;

import lombok.Data;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class KafkaConsumer {
    public static List<String> messages = new ArrayList<>();
    private final static String topic = "kafka-test";
    private final static String groupId = "kafka-test-group-id";

    @KafkaListener(topics = topic, groupId = groupId)
    public void listen(String message) {
        messages.add(message);
        System.out.println("Consuming the message: " + message);
    }
}
