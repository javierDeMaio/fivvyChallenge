package FivvyChallenge.Backend.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import FivvyChallenge.Backend.Entity.Acceptance;

@Repository
public interface AcceptanceRepository extends MongoRepository<Acceptance, Integer> {
	List<Acceptance> findByUserId(Long userId);

}
