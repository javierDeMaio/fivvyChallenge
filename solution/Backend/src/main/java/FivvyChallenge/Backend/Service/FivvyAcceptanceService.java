package FivvyChallenge.Backend.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FivvyChallenge.Backend.Entity.Acceptance;
import FivvyChallenge.Backend.Exception.NotFoundException;
import FivvyChallenge.Backend.Repository.AcceptanceRepository;

@Service
public class FivvyAcceptanceService {

	@Autowired
	private AcceptanceRepository acceptanceRepository;

	public Acceptance createAcceptance(Acceptance acceptance) {
		Date currentDate = new Date();
		acceptance.setCreateAt(currentDate);
		Acceptance saved = acceptanceRepository.save(acceptance);
		return saved;
	}

	public List<Acceptance> getAcceptance(Long userId) {
		if (userId != null) {
			List<Acceptance> saved = acceptanceRepository.findByUserId(userId);
			if (saved.isEmpty()) {
				throw new NotFoundException("No acceptances found for the text provided");
			}
			return saved;
		}
		List<Acceptance> saved = acceptanceRepository.findAll();
		return saved;

	}
}
