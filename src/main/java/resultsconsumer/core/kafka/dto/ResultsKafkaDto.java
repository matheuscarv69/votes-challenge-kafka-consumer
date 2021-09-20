package resultsconsumer.core.kafka.dto;

import resultsconsumer.entities.vote.entity.TypeVote;

import java.util.HashMap;
import java.util.Map;

public class ResultsKafkaDto {

    private Map<TypeVote, Integer> results = new HashMap<>();

    public ResultsKafkaDto(Map<TypeVote, Integer> results) {
        this.results = results;
    }

    public ResultsKafkaDto() {
    }

    public Map<TypeVote, Integer> getResults() {
        return results;
    }

    public void setResults(Map<TypeVote, Integer> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ResultsKafkaDto{" +
                "results=" + results +
                '}';
    }
}
