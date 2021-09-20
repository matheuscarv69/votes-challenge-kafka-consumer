package resultsconsumer.entities.results.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import resultsconsumer.entities.results.entity.Results;

public interface ResultsRepository extends JpaRepository<Results, Long> {
}
