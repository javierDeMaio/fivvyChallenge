package FivvyChallenge.Backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FivvyChallenge.Backend.Entity.Acceptance;
import FivvyChallenge.Backend.Service.FivvyAcceptanceService;

@RestController
@RequestMapping("/api/acceptances")
public class FivvyAcceptanceController {
	private final FivvyAcceptanceService fivvyAcceptanceService;

	@Autowired
	public FivvyAcceptanceController(FivvyAcceptanceService fivvyAcceptanceService) {
		this.fivvyAcceptanceService = fivvyAcceptanceService;
	}

	@PostMapping
	public ResponseEntity<Acceptance> createAcceptance(@RequestBody Acceptance acceptance) {
		Acceptance createdAcceptance = fivvyAcceptanceService.createAcceptance(acceptance);
		return new ResponseEntity<>(createdAcceptance, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Acceptance>> getAcceptancesByUserId(
			@RequestParam(value = "user_id", required = false) Long userId) {
		List<Acceptance> acceptances;
		acceptances = fivvyAcceptanceService.getAcceptance(userId);

		return new ResponseEntity<>(acceptances, HttpStatus.OK);
	}

}