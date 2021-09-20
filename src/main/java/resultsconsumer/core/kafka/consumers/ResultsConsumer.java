package resultsconsumer.core.kafka.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import resultsconsumer.core.kafka.dto.ResultsKafkaDto;
import resultsconsumer.entities.results.entity.Results;
import resultsconsumer.entities.results.repositories.ResultsRepository;
import resultsconsumer.entities.vote.entity.TypeVote;

@Component
public class ResultsConsumer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ResultsRepository repository;

    @Value("${kafka.topic.results}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${kafka.topic.results}", groupId = "${spring.kafka.group-id}", containerFactory = "resultsKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, ResultsKafkaDto> record) {
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());

        Integer yesQuantity = record.value().getResults().get(TypeVote.Sim);
        Integer noQuantity = record.value().getResults().get(TypeVote.Nao);

        Results results = new Results(yesQuantity, noQuantity);

        repository.save(results);
    }

}
