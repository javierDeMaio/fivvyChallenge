package FivvyChallenge.Backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FivvyChallenge.Backend.Entity.Disclaimer;
import FivvyChallenge.Backend.Service.FivvyDisclaimerService;

@RestController
@RequestMapping("/api/disclaimers")

public class FivvyDisclaimerController {

	@Autowired
	private FivvyDisclaimerService fivvyDisclaimerService;

	@GetMapping
	public ResponseEntity<List<Disclaimer>> getDisclaimers(
			@RequestParam(value = "text", required = false) String text) {
		List<Disclaimer> disclaimers = fivvyDisclaimerService.getDisclaimers(text);
		return new ResponseEntity<>(disclaimers, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Disclaimer> createDisclaimer(@RequestBody Disclaimer disclaimer) {
		disclaimer = fivvyDisclaimerService.createDisclaimer(disclaimer);
		return new ResponseEntity<>(disclaimer, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Disclaimer> updateDisclaimer(@PathVariable String id, @RequestBody Disclaimer disclaimer) {
		Disclaimer updatedDisclaimer = fivvyDisclaimerService.updateDisclaimer(id, disclaimer);
		if (updatedDisclaimer != null) {
			return new ResponseEntity<>(updatedDisclaimer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDisclaimer(@PathVariable String id) {
		boolean deleted = fivvyDisclaimerService.deleteDisclaimer(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}