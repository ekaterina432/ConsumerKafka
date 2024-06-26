package org.example.consumers;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumer {
private static final Logger log = LoggerFactory.getLogger(KafkaMessageConsumer.class);
    @KafkaListener(topics = "devglan-partitions-topic", groupId = "test-group")
    public void listen(ConsumerRecord<String, String> record) {
        log.info(String.format("Topic - %s, Partition - %d, Value: %s", record.topic(), record.partition(), record.value()));
    }
}
