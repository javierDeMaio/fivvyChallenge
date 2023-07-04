package FivvyChallenge.Backend.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FivvyChallenge.Backend.Entity.Disclaimer;
import FivvyChallenge.Backend.Exception.NotFoundException;
import FivvyChallenge.Backend.Repository.DisclaimerRepository;

@Service
public class FivvyDisclaimerService {

	@Autowired
	private DisclaimerRepository disclaimerRepository;

	public List<Disclaimer> getDisclaimers(String text) {
		if (text != null) {
			List<Disclaimer> found = disclaimerRepository.findByTextContaining(text);
			if (found.isEmpty()) {
				throw new NotFoundException("No legal notices found for the text provided");
			}
			return found;
		} else {
			return disclaimerRepository.findAll();
		}
	}

	public Disclaimer createDisclaimer(Disclaimer disclaimer) {
		Date currentDate = new Date();
		disclaimer.setCreateAt(currentDate);
		disclaimer.setVersion(1l);
		Disclaimer created = disclaimerRepository.save(disclaimer);
		return created;
	}

	public Disclaimer updateDisclaimer(String id, Disclaimer updatedDisclaimer) {
		List<Disclaimer> found = disclaimerRepository.findById(id);
		if (found.isEmpty()) {
			throw new NotFoundException("No legal notices found to update with the provided id");
		}
		Long currentVersion = found.get(0).getVersion();
		updatedDisclaimer.setVersion(++currentVersion);
		updatedDisclaimer.setCreateAt(found.get(0).getCreateAt());
		Date currentDate = new Date();
		updatedDisclaimer.setUpdateAt(currentDate);
		updatedDisclaimer.setId(id);
		disclaimerRepository.save(updatedDisclaimer);
		return updatedDisclaimer;

	}

	public boolean deleteDisclaimer(String id) {
		List<Disclaimer> found = disclaimerRepository.findById(id);
		if (found.isEmpty()) {
			throw new NotFoundException("No legal notices found to delete with the provided id");
		}
		disclaimerRepository.delete(found.get(0));
		return true;
	}
}
