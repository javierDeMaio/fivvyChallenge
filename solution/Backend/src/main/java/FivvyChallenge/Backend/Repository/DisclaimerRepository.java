package FivvyChallenge.Backend.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import FivvyChallenge.Backend.Entity.Disclaimer;

@Repository
public interface DisclaimerRepository extends MongoRepository<Disclaimer, Integer> {

	List<Disclaimer> findByTextContaining(String text);

	List<Disclaimer> findById(String id);

	void deleteById(List<Disclaimer> found);

}
