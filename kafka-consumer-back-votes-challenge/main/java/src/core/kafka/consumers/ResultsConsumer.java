package src.core.kafka.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import src.core.kafka.dto.ResultsKafkaDto;

@Component
public class ResultsConsumer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${kafka.topic.results}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${kafka.topic.results}", groupId = "${spring.kafka.group-id}", containerFactory = "resultsKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, ResultsKafkaDto> record) {
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());
    }

}
